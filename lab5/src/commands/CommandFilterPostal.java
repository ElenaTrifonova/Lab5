package commands;

import collection.Organization;
import worker.FileManager;
/**
 * Class that represents command filter_by_postal_address
 */
public class CommandFilterPostal {
    /**
     * Method show elements with
     * the sane field postal address
     * @param man
     * @param postal
     */
    public static void filter_postal(FileManager man, String postal) {
        if (man.getCollection().size() > 0) {
            int cout = 0;
            System.out.println("Elements, that have the same postal address:");
            for (Organization org : man.getCollection().values()) {
                cout++;
                if (org.getPostalAddress().toString().equals(postal)) System.out.println(org.toString());
            }
            if (cout == 0) System.out.println("There are no elements with the same postal address in the collection");
        } else System.out.println("Collection is empty");
    }
}
