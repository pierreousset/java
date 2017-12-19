package model;

public class UserSimple {

    private String email;
    private String ipAddress;
    private String password;

    public UserSimple(String email, String ipAddress, String password)
    {
        this.email = email;
        this.ipAddress = ipAddress;
        this.password = password;
    }
}
