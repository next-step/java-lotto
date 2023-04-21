package step1;

public class UserInput {

    private static final String VALID_INPUT_FORMAT = "-?\\d+( [+\\-*/] -?\\d+)*";

    private final String input;

    private UserInput(String input) {
        this.input = input;
    }

    public static UserInput of(String input) {
        if (isValidInput(input)) {
            return new UserInput(input);
        }
        throw new IllegalArgumentException("입력 포맷이 연산 가능하지 않습니다.");
    }

    private static boolean isValidInput(String input) {
        return input.matches(VALID_INPUT_FORMAT);
    }

    public String getInput() {
        return input;
    }
}
