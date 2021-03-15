package commands;

import collection.Organization;
import worker.FileManager;
/**
 * Class that represents command average_of_employees_count
 */
public class CommandAverage {
    /**
     * Method counts the average of employees count
     * in organizations
     * @param man
     */
    public static void average(FileManager man) {
        double average = 0;

        long sum = 0;
        for (Organization org : man.getCollection().values()) {
            sum = sum + org.getEmployeesCount();
        }
        average = sum / man.getCollection().size();

        System.out.println("Average of employees count is " + average);
    }

}
