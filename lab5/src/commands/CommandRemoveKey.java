package commands;

import worker.FileManager;
/**
 * Class that represents command remove_key
 */
public class CommandRemoveKey {
    /**
     * Method removes elements with
     * keys more than given
     * @param man
     * @param argument
     */
    public static void remove_key(FileManager man, Long argument) {
        System.out.println("Available keys:" + man.getCollection().keySet());
        int startSize = man.getCollection().size();
        man.getCollection().remove(argument);
        if (startSize == man.getCollection().size()) {
            System.out.println("Element wasn't deleted. Maybe key isn't exist.");
        } else {
            System.out.println("Element was deleted.");
        }
    }
}
