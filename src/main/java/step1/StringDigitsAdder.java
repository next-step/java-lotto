package step1;

public class StringDigitsAdder {
    private AddCommand addCommand;

    public StringDigitsAdder(String rawInput) {
        this.addCommand = new AddCommand(rawInput);
    }

    public int calculate() {
        return -1;
    }
}
