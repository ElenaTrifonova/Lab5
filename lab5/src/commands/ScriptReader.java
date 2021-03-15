package commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class that works with scripts
 */
public class ScriptReader {
    /**
     * Method that reads file and create massive of commands
     * @param file
     * @return ArrayList<String> commands
     */
    public static ArrayList<String> readCommand(String file){
        ArrayList<String> commands = new ArrayList<>();
        try {
            FileReader reader = new FileReader(file);
            BufferedReader byfferedReader = new BufferedReader(reader);
            String line = byfferedReader.readLine();

            while (line !=null){
                commands.add(line);
                line = byfferedReader.readLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return commands;
    }

    /**
     * Method checks file
     * @param filePath
     * @return File script
     * @return null
     */
    public static File checkFile(String filePath) {
        File script = new File(filePath);

        if (!script.exists() || !script.isFile()) {
            System.out.println(("File with path " + script.getAbsolutePath() + " doesn't exist."));
            return null;
        }
        if (!script.canRead()) {
            System.out.println("File is protected from reading.");
            return null;
        }
        if (script.length() == 0) {
            System.out.println("There is no command in the script.");
            return null;
        }
        return script;
    }

}
