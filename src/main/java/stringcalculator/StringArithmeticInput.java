package stringcalculator;

public class StringArithmeticInput {
    private static final String DELIMITER = " ";

    private final String input;
    public StringArithmeticInput(String input) {
        if (input == null || input.equalsIgnoreCase("")) {
            throw new IllegalArgumentException("공백은 불가능합니다");
        }

        this.input = input;
    }

    public Number evaluate() {
        String[] expression = input.split(DELIMITER);

        Number leftNumber = null;
        Command command = null;
        Number rightNumber = null;

        for (String value : expression) {
            if (isNumber(value)) {
                if (leftNumber == null) {
                    leftNumber = Number.parse(value);
                } else if (rightNumber == null) {
                    rightNumber = Number.parse(value);
                }
            } else {
                command = new CommandFactory().getCommand(value);
            }

            if (leftNumber != null && command != null && rightNumber != null) {
                leftNumber = command.execute(leftNumber, rightNumber);

                command = null;
                rightNumber = null;
            }
        }

        return leftNumber;
    }

    private boolean isNumber(String value) {
        try {
            Number.parse(value);
            return true;
        } catch(Exception e){
            return false;
        }
    }
}
