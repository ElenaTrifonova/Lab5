package commands;

import worker.FileManager;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Class that represents command clear
 */
public class CommandExecuteScript {

    /**
     * Method works with scripts
     * @param manFile
     * @param file
     * @throws IOException
     */
    public static void execute_script(FileManager manFile, String file) throws IOException {
        if (ScriptReader.checkFile(file) != null) {
            ArrayList<String> commandsScript = ScriptReader.readCommand(file);
            System.out.println(commandsScript);
            CommandManager manCommand = new CommandManager();

            for (String command : commandsScript) {

                if (command.split(" ").length == 2 && command.split(" ")[0].equals("execute_script") && command.split(" ")[1].equals(file)) {
                    throw new IllegalArgumentException("Recursion of scripts!");
                }

                manCommand.interactive_mode_scr(manFile, command);
            }
        }
    }
}
