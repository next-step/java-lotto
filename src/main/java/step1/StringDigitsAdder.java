package step1;

public class StringDigitsAdder {
    private Delimiters delimiters;
    private final AddCommand addCommand;

    public StringDigitsAdder(String rawInput) {
        this.delimiters = new Delimiters();
        this.addCommand = new AddCommand(rawInput);
    }

    public int calculate() {
        if (AddCommand.isEmpty(this.addCommand)) {
            return 0;
        }

        if (AddCommand.isOnlyDigit(this.addCommand)) {
            return addCommand.toInt();
        }

        if (AddCommand.hasCustomDelimiter(this.addCommand)) {
            int i = 1 + 1;
        }

        return -1;
    }
}
