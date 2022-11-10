package Place.Order.Program;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


class TechAssessment {

    public final static CloseableHttpClient httpClient = HttpClients.createDefault();
    public final static ObjectMapper mapper = new ObjectMapper();
    public final static String username =  "INSERT USERNAME";
    public final static String password = "INSERT PASSWORD";
    public final static String authorisationEndpoint = "INSERT AUTHORISATION ENDPOINT";
    public final static String placeOrderEndpoint = "INSERT PLACE ORDER ENDPOINT";

    public static void main(String[] args) throws Exception {

        //Check the input argument
        Path path;
        try {
            path = Path.of(args[0]);
        } catch (Exception e) {
            throw new Exception("Invalid or no input argument found, please make sure the input is as " +
                    "follows: java -jar Run_Place_Order.jar <path to csv>");
        }

        // get API Token
        Token_API_Body userDetails = new Token_API_Body(username, password);
        StringEntity json = new StringEntity(mapper.writeValueAsString(userDetails),
                ContentType.APPLICATION_JSON);
        CloseableHttpResponse response = postRequest(json, authorisationEndpoint, "");
        Token_API_Response tokenInformation = mapper.readValue(response.getEntity().getContent(), Token_API_Response.class);

        //initialise the variation in the order number and the product order payload objects
        int orderIncrementer = 0;
        Order_Payload orderPayload = new Order_Payload();
        Order_Lines[] orderLines = {new Order_Lines("TEST-SKU01", 2), new Order_Lines("TEST-SKU02", 1)};

        // read through each line of the csv file
        Iterator csvFileIterator = Files.lines(path).skip(1).iterator();

        // read csv and send the request in the same loop for efficiency when scaling
        while (csvFileIterator.hasNext()) {

            //populate the order payload object and convert it to json body
            String orderNumber = "MONZ000" + orderIncrementer;
            Deliver_To deliverTo = getAndSetDeliveryInformation(csvFileIterator.next().toString());
            orderPayload.setOrder_number(orderNumber);
            orderPayload.setDeliver_to(deliverTo);
            orderPayload.setOrder_lines(orderLines);
            String errors = DeliverToValidation(orderNumber, orderPayload.getDeliver_to());
            StringEntity orderJson = new StringEntity(mapper.writeValueAsString(orderPayload),
                    ContentType.APPLICATION_JSON);

            if (errors == null) {
                response = postRequest(orderJson, placeOrderEndpoint, tokenInformation.getToken());
                // process the response and grab the required information
                Order_Response_Payload orderResponsePayload = mapper.readValue(response.getEntity().getContent(),
                        Order_Response_Payload.class);
                System.out.println( "Name: " + orderPayload.getDeliver_to().getName() + " \n" +
                        "Company Order Number: " + orderResponsePayload.getCompany_order_number() +
                        "\nOrder Number: " + orderResponsePayload.getOrder_number() + "\n");
                orderIncrementer++;
            } else {
                System.out.println("Name: " + orderPayload.getDeliver_to().getName() + " Error: " + errors + "\n");
            }

        }

    }

    static CloseableHttpResponse postRequest(StringEntity json, String requestURL, String auth_token) throws IOException {
        HttpPost request = new HttpPost(requestURL);
        request.setEntity(json);
        request.setHeader("Authorization", "Bearer " + auth_token);
        CloseableHttpResponse response = httpClient.execute(request);
        if (response.getStatusLine().getStatusCode() != 200) {
            System.out.println("Something went wrong - Status Code: " + response.getStatusLine().getStatusCode());
        }
        return response;
    }

    // extract information from CSV lines and populate the address_lines object
    static Deliver_To getAndSetDeliveryInformation(String line) {
        String[] fields = line.split(",");
        if (fields.length != 8)
            throw new RuntimeException("Invalid CSV line - " + line);
        String[] addressLines = {fields[1], fields[2], fields[3], fields[4]};
        return new Deliver_To(fields[0], addressLines, fields[5], fields[6], fields[7]);
    }

    static String DeliverToValidation(String orderNumber, Deliver_To deliverTo) {
        if (orderNumber.length() < 1 | orderNumber.length() > 14) {
            return "Invalid orderNumber";
        }
        String name = deliverTo.getName();
        if (name.length() < 5 | name.length() > 30) {
            return "Invalid Name";
        }
        if (deliverTo.getPostal_code().equals("") | deliverTo.getPostal_code().length() > 8) {
            return "Invalid Postal Code";
        }
        if (deliverTo.getEmail_address().length() > 254 | !deliverTo.getEmail_address().contains("@")) {
            return "Invalid Email Address";
        }
        if (deliverTo.getPhone_number().length() > 30) {
            return "Invalid Phone Number";
        }
        String[] address_lines = deliverTo.getAddress_lines();
        long emptyCount = new ArrayList<>(Arrays.asList(address_lines)).stream().
                filter(a -> a.equals("")).count();
        boolean lengthValidation = new ArrayList<>(Arrays.asList(address_lines)).stream().
                filter(a -> a.length() > 30).findFirst().isEmpty();
        if (emptyCount > 2 | !lengthValidation) {
            return "Invalid Address Lines";
        }
        return null;
    }
}