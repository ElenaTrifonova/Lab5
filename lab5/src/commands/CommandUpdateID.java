package commands;

import collection.OrgGeneration;
import collection.Organization;
import worker.FileManager;

/**
 * Class that represents command update
 */
public class CommandUpdateID {
    /**
     * Method updates the element with given key
     *
     * @param man
     * @param id
     */
    public static void update(FileManager man, Long id) {
        if (man.getCollection().size() > 0) {
            int cout = 0;
            for (Organization org : man.getCollection().values()) {
                if (org.getId().equals(id)) {
                    cout++;
                    org = OrgGeneration.generate();
                    man.getCollection().put(id, org);


                }
            }
            if (cout == 0) {
                System.out.println("There are no same id in the collection. Collection wasn't update");
            } else System.out.println("Collection was update " + cout + " time");

        } else System.out.println("Collection is empty");
    }
}
