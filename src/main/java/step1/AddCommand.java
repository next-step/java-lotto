package step1;

import java.util.IllegalFormatConversionException;

public class AddCommand {
    private final String value;
    private final Delimiters delimiters;

    public AddCommand(String value) {
        this.delimiters = DelimitersFactory.createDelimiters(value);
        this.value = value;
    }

    public static boolean isEmpty(AddCommand addCommand) {
        return addCommand.value == null || addCommand.value.isEmpty();
    }

    public static boolean isOnlyDigit(AddCommand addCommand) {
        return addCommand.value.matches("^\\d+$");
    }

    public int toInt() {
        if (!isOnlyDigit(this)) {
            throw new IllegalFormatConversionException('s', String.class);
        }

        return Integer.parseInt(this.value);
    }

    public static boolean containsNegative(AddCommand addCommand) {
        return addCommand.value.matches(".*-\\d+.*");
    }

    public int execute() {
        return this.delimiters.parse(this.value)
                .stream()
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
    }
}
