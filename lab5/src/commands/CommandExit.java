package commands;
/**
 * Class that represents command exit
 */
public class CommandExit {
    /**
     * Method finishes the program
     * without saving file
     */
    public static void exit(){
        System.out.println("The program is finished without saving collection. Have a good day!");
        System.exit(0);
    }
}
