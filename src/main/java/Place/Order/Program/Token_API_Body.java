package Place.Order.Program;

public class Token_API_Body {
    private final String email;
    private final String password;

    public Token_API_Body(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User_Details{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
