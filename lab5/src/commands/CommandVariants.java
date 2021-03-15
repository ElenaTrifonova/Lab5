package commands;
/**
 * Enumeration with the description of commands
 */
public enum CommandVariants {

    HELP("help: вывести справку по доступным командам"),
    INFO("info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)"),
    SHOW("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении"),
    INSERT("insert null {element} : добавить новый элемент с заданным ключом"),
    UPDATE("update id {element} : обновить значение элемента коллекции, id которого равен заданному"),
    REMOVE_KEY("remove_key null : удалить элемент из коллекции по его ключу"),
    CLEAR("clear : очистить коллекцию"),
    SAVE("save : сохранить коллекцию в файл"),
    EXECUTE_SCRIPT("execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме."),
    EXIT("exit : завершить программу (без сохранения в файл)"),
    REMOVE_GREATER("remove_greater {element} : удалить из коллекции все элементы, превышающие заданный"),
    REMOVE_GREATER_KEY("remove_greater_key null : удалить из коллекции все элементы, ключ которых превышает заданный"),
    REMOVE_LOWER_KEY("remove_lower_key null : удалить из коллекции все элементы, ключ которых меньше, чем заданный"),
    AVERAGE("average_of_employees_count : вывести среднее значение поля employeesCount для всех элементов коллекции"),
    MAX("max_by_creation_date : вывести любой объект из коллекции, значение поля creationDate которого является максимальным"),
    FILTER("filter_by_postal_address postalAddress : вывести элементы, значение поля postalAddress которых равно заданному");

    private final String name;

    CommandVariants(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
