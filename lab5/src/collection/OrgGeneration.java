package collection;

import java.util.NoSuchElementException;
import java.util.Scanner;

 /**
 * Class that generates organization
 */
public class OrgGeneration {
    /**
     * Method creates Organization
     * @return Organization
     */
    public static Organization generate() {
        Organization organization = null;
        try {
            Scanner scanner = new Scanner(System.in);
            String name = "";
            do {
                System.out.println("Enter the name of the organization:");
                try {
                    name = scanner.nextLine();
                } catch (NumberFormatException e) {
                    System.out.println("Error of entering");
                }
            } while (name.isEmpty());

            float x = 0;
            do {
                System.out.println("Enter the coordinate X:");
                try {
                    x = Float.valueOf(scanner.nextLine());
                    if (x > -164) {
                        System.out.println("Coordinate X can't be more than -164");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error of entering");
                }
            } while (x > -164);

            Integer y = null;
            do {
                System.out.println("Enter the coordinate Y:");
                try {
                    y = Integer.valueOf(scanner.nextLine());
                    if (y == 0) {
                        System.out.println("Coordinate Y can't be 0");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error of entering");
                }
            } while (y == null);

            Double annualTurnover = null;
            //do {
                System.out.println("Enter the annual turnover:");
                try {
            String annualTurnover_str = scanner.nextLine();
                    if (annualTurnover_str.length() == 0) {
                        annualTurnover = null;
                        System.out.println("Nothing was found in the string. Annual turnover will be null.");
                    }
                    else {
                        annualTurnover = Double.valueOf(annualTurnover_str);
                        if (annualTurnover < 0) {
                            System.out.println("Annual turnover can't be  less than null");
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error of entering");
                }


            long employeesCount = 0;
            do {
                System.out.println("Enter the employees count:");
                try {
                    employeesCount = Long.valueOf(scanner.nextLine());
                    if (employeesCount <= 0) {
                        System.out.println("Employees count can't be null or less than 0");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error of entering");
                }
            } while (employeesCount <= 0);

            String zipCode = "";
            do {
                System.out.println("Enter the zip code:");
                try {
                    zipCode = scanner.nextLine();
                    if (zipCode.length() < 3) {
                        System.out.println("Length of zip code can't be less than 3");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error of entering");
                }
            } while (zipCode.length() < 3 || zipCode.isEmpty());

            OrganizationType type;
            while (true) {
                System.out.println("Enter the type:");
                System.out.println("You can choose it from these variants:");
                for (OrganizationType org : OrganizationType.values())
                    System.out.println(org.toString()); //ПЕРЕОПРЕДЕЛИТЬ
                try {
                    type = OrganizationType.valueOf(scanner.nextLine());
                    if (type == null) {
                        System.out.println("Type can't be null");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Error of entering");
                    continue;
                }
                break;
            }

            java.time.LocalDateTime creationDate;
            creationDate = java.time.LocalDateTime.now();
            System.out.println("Creation date:");
            System.out.println(creationDate);

            Long id;
            id = (long) (Math.random() * 111 + 23);
            System.out.println("Unique ID:");
            System.out.println(id);

            String fullName;
            fullName = getAlphaNumericString(6);
            System.out.println("Unique full name:");
            System.out.println(fullName);

            Coordinates coordinates = new Coordinates(x, y);
            Address postalAddress = new Address(zipCode);
            organization = new Organization(id, name, coordinates, creationDate, annualTurnover, fullName, employeesCount, type, postalAddress);


        } catch (NoSuchElementException e) {
            System.out.println("Entering was finished");
        }
        return organization;
    }

    /**
     * Method creates unique full name
     * @param n
     * @return String
     */
    static String getAlphaNumericString(int n) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }
}
