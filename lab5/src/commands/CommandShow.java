package commands;

import worker.FileManager;
/**
 * Class that represents command show
 */
public class CommandShow{
    /**
     * Method shows us what collection contains
     * @param man
     */
    public static void show(FileManager man){
        if (man.getCollection().size() == 0){
            System.out.println("Collection is empty.");
        }
        else{
            System.out.println("Elements of collection:");
            man.getCollection().forEach ((k, v) ->{

                System.out.println("Key:" + k);
                System.out.println("Value:" + v.toString());
            });
        }
    }
}
