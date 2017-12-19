package domain;

import javax.validation.constraints.NotBlank;

public class Restaurant {

    private static String NAME_PATTERN = "%s %s %s";

    @NotBlank
    private String name;
    @NotBlank
    private String address;
    @NotBlank
    private String userBoss;
    @NotBlank
    private String phoneNumber;


    public Restaurant(String name, String address, String userBoss, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.userBoss = userBoss;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return String.format(NAME_PATTERN, name);
    }

    public String getAddress() {
        return address;
    }

    public String getUserBoss() {
        return userBoss;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

