package Place.Order.Program;

class Order_Response_Payload {
    private String trade_code;
    private String order_number;
    private int company_order_number;
    private String order_date;
    private String order_status;
    private String ex_vat_total;
    private String vat;
    private String inc_vat_total;
    private String email_address;
    private String phone_number;
    private Response_Order_Lines[] order_lines;

    public Order_Response_Payload() {
        super();
    }

    public Order_Response_Payload(String trade_code, String order_number, int company_order_number, String order_date, String order_status, String ex_vat_total, String vat, String inc_vat_total, String email_address, String phone_number, Response_Order_Lines[] order_lines) {
        this.trade_code = trade_code;
        this.order_number = order_number;
        this.company_order_number = company_order_number;
        this.order_date = order_date;
        this.order_status = order_status;
        this.ex_vat_total = ex_vat_total;
        this.vat = vat;
        this.inc_vat_total = inc_vat_total;
        this.email_address = email_address;
        this.phone_number = phone_number;
        this.order_lines = order_lines;
    }

    public String getTrade_code() {
        return trade_code;
    }

    public String getOrder_number() {
        return order_number;
    }

    public int getCompany_order_number() {
        return company_order_number;
    }

    public String getOrder_date() {
        return order_date;
    }

    public String getOrder_status() {
        return order_status;
    }

    public String getEx_vat_total() {
        return ex_vat_total;
    }

    public String getVat() {
        return vat;
    }

    public String getInc_vat_total() {
        return inc_vat_total;
    }

    public String getEmail_address() {
        return email_address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public Response_Order_Lines[] getOrder_lines() {
        return order_lines;
    }
}

class Response_Order_Lines {
    private String status;
    private String description;
    private int quantity;
    private float price;
    private float vat;
    private String sku;
    private float ex_vat_total;
    private float inc_vat_total;

    public Response_Order_Lines() {
        super();
    }

    public Response_Order_Lines(String status, String description, int quantity, float price, float vat, String sku,
                                float ex_vat_total, float inc_vat_total) {
        this.status = status;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.vat = vat;
        this.sku = sku;
        this.ex_vat_total = ex_vat_total;
        this.inc_vat_total = inc_vat_total;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }

    public float getVat() {
        return vat;
    }

    public String getSku() {
        return sku;
    }

    public float getEx_vat_total() {
        return ex_vat_total;
    }

    public float getInc_vat_total() {
        return inc_vat_total;
    }
}


