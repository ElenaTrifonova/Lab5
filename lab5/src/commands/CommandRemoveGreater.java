package commands;

import collection.Organization;
import worker.FileManager;

import java.util.Set;

/**
 * Class that represents command remove_greater
 */
public class CommandRemoveGreater {
    /**
     * Method removes elements,
     * which id more than  given
     * @param man
     * @param argument
     */
    public static void remove_greater(FileManager man, Long argument) {
        int startSize = man.getCollection().size();
        if (startSize > 0) {

            Set<Long> set = man.getCollection().keySet();

            int cout_del = 0;
            for (Organization org : man.getCollection().values()) {
                while (set.iterator().hasNext()) {

                    Long key = set.iterator().next();
                    if (org.getId() > argument) {
                        cout_del++;
                        man.getCollection().remove(key);
                    }
                }
                if (cout_del > 0) System.out.println(cout_del + " elements were deleted");
                else System.out.println("Nothing was changed. There are no elements bigger than given.");

            }
        } else System.out.println("Collection is empty");
    }
}
