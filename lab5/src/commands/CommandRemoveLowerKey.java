package commands;

import worker.FileManager;
/**
 * Class that represents command remove_lower_key
 */
public class CommandRemoveLowerKey {
    /**
     * Method that runs the command remove_lower_key,
     * that deleted elements with key, that less than given
     * @param man
     * @param argument
     */
    public static void remove_lower_key(FileManager man, Long argument) {
        int startSize = man.getCollection().size();
        if (startSize != 0) {
            int cout = 0;
            for (Long key : man.getCollection().keySet()) {
                if (key < argument) man.getCollection().remove(key);
                cout++;
            }
            if (cout > 0) {
                System.out.println(cout + " keys(with elements) were deleted");
            } else System.out.println("Collection wasn't changed");

        } else System.out.println("Collection is empty.");
    }
}
