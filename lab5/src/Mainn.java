import collection.OrgGeneration;
import collection.Organization;
import commands.CommandManager;
import worker.FileManager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Main class of the program
 */
public class Mainn{
    public static void main(String[] args) throws IOException {

        String filepath = System.getenv("FilePath");
        Hashtable<Long, Organization> collection = new Hashtable<>();

        Scanner scanner = new Scanner(System.in);
        int count;
        try {
            System.out.println("The number of elements in collection?: ");
            count = Integer.parseInt(scanner.nextLine());
            if (count > 0) {
                for (int i = 1; i <= count; i++) {
                    Organization org = OrgGeneration.generate();
                    collection.put(org.getEmployeesCount() % 10 + org.getId() % 10 + 94, org);
                }
            } else {
                System.out.println("Anyway one element will be created.");
                Organization org = OrgGeneration.generate();
                collection.put(org.getEmployeesCount() % 10 + org.getId() % 10 + 98, org);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error of entering");
        }


        FileManager manFile = new FileManager();
        manFile.save(collection);
        manFile.loadCollection(filepath);


        CommandManager manCommand = new CommandManager();
        manCommand.interactive_mode(manFile);


    }
}
