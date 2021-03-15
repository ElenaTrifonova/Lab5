package collection;

/**
 * Enumeration that contains type of organization
 */
public enum OrganizationType {
    PUBLIC("Public"),
    GOVERNMENT("Government"),
    TRUST("Trust"),
    PRIVATE_LIMITED_COMPANY("Private limited company"),
    OPEN_JOINT_STOCK_COMPANY("Open joint stock company");

    private final String name;

    OrganizationType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
