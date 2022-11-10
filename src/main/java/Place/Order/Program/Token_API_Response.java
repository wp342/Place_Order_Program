package Place.Order.Program;

public class Token_API_Response {
    private String token;
    private String expires_on;

    public Token_API_Response() {
        super();
    }

    public Token_API_Response(String token, String expires_on) {
        this.token = token;
        this.expires_on = expires_on;

    }

    public String getToken() {
        return token;
    }

    public String getExpires_on() {
        return expires_on;
    }

    @Override
    public String toString() {
        return "Token_Infomation{" +
                "token='" + token + '\'' +
                ", expires_on='" + expires_on + '\'' +
                '}';
    }
}
