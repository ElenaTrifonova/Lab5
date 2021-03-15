package commands;
/**
 * Class that represents command help
 */
public class CommandHelp {
    /**
     * Method shows us available commands
     */
    public static void help(){
        System.out.println("Information about available commands:");
        for(CommandVariants var: CommandVariants.values()){
            System.out.println(var.getName());
        }
    }
}
