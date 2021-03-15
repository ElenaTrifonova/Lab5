package commands;

import worker.FileManager;

/**
 * Class that represents command info
 */
public class CommandInfo {

    /**
     * Method that shows us information about file
     * @param man
     */

    public static void info(FileManager man){
        System.out.println("Type of collection: "+man.getCollection().getClass().toString());
        System.out.println("Path: " + man.getFile());
    }
}
