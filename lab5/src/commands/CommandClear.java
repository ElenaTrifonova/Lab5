package commands;

import worker.FileManager;
/**
 * Class that represents command clear
 */
public class CommandClear {
    /**
     * Method clears the collection
     * @param man
     */
    public static void clear(FileManager man){
        if (man.getCollection().size() == 0) {
            System.out.println("Collection is already empty");
        } else {
            man.getCollection().clear();
            System.out.println("Collection was cleared");
        }
    }

}
