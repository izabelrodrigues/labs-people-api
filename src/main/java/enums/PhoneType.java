package enums;/* Created by Izabel Rodrigues */

public enum PhoneType {

    HOME("home"),
    MOBILE("mobile"),
    COMMERCIAL("commercial");

    private String description;

    PhoneType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
