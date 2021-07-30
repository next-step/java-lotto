package step1;

public class StringDigitsAdder {
    private final AddCommand addCommand;

    public StringDigitsAdder(String rawInput) {
        this.addCommand = new AddCommand(rawInput);
    }

    public int calculate() {
        if (AddCommand.isEmpty(this.addCommand)) {
            return 0;
        }

        if (AddCommand.isOnlyDigit(this.addCommand)) {
            return addCommand.toInt();
        }

        if (AddCommand.containsNegative(this.addCommand)) {
            throw new RuntimeException("입력 문자열에 음수가 포함될 수 없습니다.");
        }

        return this.addCommand.execute();
    }
}
