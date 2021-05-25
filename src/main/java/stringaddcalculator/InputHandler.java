package stringaddcalculator;

public class InputHandler {

    private static final String INPUT_REGEX = "^[0-9]+$";

    public boolean isEmptyInput(String input) {
        return input == null || input.length() == 0;
    }

    public void illegalInputFilter(String input) {
        if (!input.matches(INPUT_REGEX)) {
            throw new RuntimeException("숫자 이외의 값 또는 음수는 사용할 수 없습니다.");
        }
    }
}
