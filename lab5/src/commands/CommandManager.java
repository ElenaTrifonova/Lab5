package commands;

import worker.FileManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//ОБРАБОТКА КОМАНД
public class CommandManager {

    private String userCommand;
    private String[] command;


    public void interactive_mode(FileManager man) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                userCommand = reader.readLine();
                command = userCommand.trim().split(" ", 2);
                try {
                    switch (command[0]) {
                        case "":
                            break;
                        case "info":
                            CommandInfo.info(man);
                            break;
                        case "help":
                            CommandHelp.help();
                            break;
                        case "clear":
                            CommandClear.clear(man);
                            break;
                        case "exit":
                            CommandExit.exit();
                            break;
                        case "show":
                            CommandShow.show(man);
                            break;
                        case "remove_key":
                            try {
                                CommandRemoveKey.remove_key(man, Long.valueOf(command[1]));
                            } catch (NumberFormatException e) {
                                System.out.println("Wrong format of entering.");
                            }
                            break;
                        case "remove_greater_key":
                            try {
                                CommandRemoveGreaterKey.remove_greater_key(man, Long.valueOf(command[1]));
                            } catch (NumberFormatException e) {
                                System.out.println("Wrong format of entering.");
                            }
                            break;
                        case "remove_lower_key":
                            try {
                                CommandRemoveLowerKey.remove_lower_key(man, Long.valueOf(command[1]));
                            } catch (NumberFormatException e) {
                                System.out.println("Wrong format of entering.");
                            }
                            break;
                        case "average_of_employees_count":
                            CommandAverage.average(man);
                            break;
                        case "max_by_creation_date":
                            CommandMax.max(man);
                            break;
                        case "filter_by_postal_address":
                            CommandFilterPostal.filter_postal(man, command[1]);
                            break;
                        case "insert":
                            try {
                                CommandInsert.insert(man, Long.valueOf(command[1]));
                            } catch (NumberFormatException e) {
                                System.out.println("Wrong format of entering.");
                            }
                            break;
                        case "update":
                            CommandUpdateID.update(man, Long.valueOf(command[1]));
                            break;
                        case "save":
                            man.save(man.getCollection());
                            break;
                        case "remove_greater":
                            try {
                                CommandRemoveGreater.remove_greater(man, Long.valueOf(command[1]));

                            } catch (NumberFormatException e) {
                                System.out.println("Wrong format of entering.");
                            }
                            break;
                        case "execute_script":
                            CommandExecuteScript.execute_script(man, command[1]);
                            break;
                        default:
                            System.out.println("This command doesn't exist.");
                            break;
                    }

                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.out.println("There are no arguments.");
                }
            }
        }

    }

    public void interactive_mode_scr(FileManager man, String userCommand) throws IOException {
        command = userCommand.trim().split(" ", 2);
        try {
            switch (command[0]) {
                case "":
                    break;
                case "info":
                    CommandInfo.info(man);
                    break;
                case "help":
                    CommandHelp.help();
                    break;
                case "clear":
                    CommandClear.clear(man);
                    break;
                case "exit":
                    CommandExit.exit();
                    break;
                case "show":
                    CommandShow.show(man);
                    break;
                case "remove_key":
                    try {
                        CommandRemoveKey.remove_key(man, Long.valueOf(command[1]));
                    } catch (NumberFormatException e) {
                        System.out.println("Wrong format of entering.");
                    }
                    break;
                case "remove_greater_key":
                    try {
                        CommandRemoveGreaterKey.remove_greater_key(man, Long.valueOf(command[1]));
                    } catch (NumberFormatException e) {
                        System.out.println("Wrong format of entering.");
                    }
                    break;
                case "remove_lower_key":
                    try {
                        CommandRemoveLowerKey.remove_lower_key(man, Long.valueOf(command[1]));
                    } catch (NumberFormatException e) {
                        System.out.println("Wrong format of entering.");
                    }
                    break;
                case "average_of_employees_count":
                    CommandAverage.average(man);
                    break;
                case "max_by_creation_date":
                    CommandMax.max(man);
                    break;
                case "filter_by_postal_address":
                    CommandFilterPostal.filter_postal(man, command[1]);
                    break;
                case "insert":
                    try {
                        CommandInsert.insert(man, Long.valueOf(command[1]));
                    } catch (NumberFormatException e) {
                        System.out.println("Wrong format of entering.");
                    }
                    break;
                case "update":
                    CommandUpdateID.update(man, Long.valueOf(command[1]));
                    break;
                case "save":
                    man.save(man.getCollection());
                    break;
                case "remove_greater":
                    try {
                        CommandRemoveGreater.remove_greater(man, Long.valueOf(command[1]));

                    } catch (NumberFormatException e) {
                        System.out.println("Wrong format of entering.");
                    }
                    break;
                case "execute_script":
                    CommandExecuteScript.execute_script(man, command[1]);
                    break;
                default:
                    System.out.println("This command doesn't exist.");
                    break;
            }

        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("There are no arguments.");
        }
    }
}

