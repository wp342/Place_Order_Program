package Place.Order.Program;

public class Order_Payload {
    private String order_number;
    private Deliver_To deliver_to;
    private Order_Lines[] order_lines;

    public Order_Payload() {
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public void setDeliver_to(Deliver_To deliver_to) {
        this.deliver_to = deliver_to;
    }

    public void setOrder_lines(Order_Lines[] order_lines) {
        this.order_lines = order_lines;
    }

    public String getOrder_number() {
        return order_number;
    }

    public Deliver_To getDeliver_to() {
        return deliver_to;
    }

    public Order_Lines[] getOrder_lines() {
        return order_lines;
    }
}

class Deliver_To {
    private String name;
    private String[] address_lines;
    private String postal_code;
    private String email_address;
    private String phone_number;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress_lines(String[] address_lines) {
        this.address_lines = address_lines;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Deliver_To(String name, String[] address_lines, String postal_code, String email_address, String phone_number) {
        this.name = name;
        this.address_lines = address_lines;
        this.postal_code = postal_code;
        this.email_address = email_address;
        this.phone_number = phone_number;
    }

    public String getName() {
        return name;
    }

    public String[] getAddress_lines() {
        return address_lines;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public String getEmail_address() {
        return email_address;
    }

    public String getPhone_number() {
        return phone_number;
    }
}

class Order_Lines {
    private String sku;
    private int quantity;

    public Order_Lines(String sku, int quantity) {
        this.sku = sku;
        this.quantity = quantity;
    }

    public String getSku() {
        return sku;
    }

    public int getQuantity() {
        return quantity;
    }
}


