package step1;

public class AddCommand {
    private final String value;

    public AddCommand(String value) {
        this.value = value;
    }

    public static boolean isEmpty(AddCommand addCommand) {
        return addCommand.value == null || addCommand.value.isEmpty();
    }

    public static boolean isOnlyDigit(AddCommand addCommand) {
        return addCommand.value.matches("^\\d+$");
    }

    public static boolean hasCustomDelimiter(AddCommand addCommand) {
        return addCommand.value.matches("^//(.)\\n(.*)");
    }
}
