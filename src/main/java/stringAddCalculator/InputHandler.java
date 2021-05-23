package stringAddCalculator;

public class InputHandler {

    String INPUT_REGEX = "^[0-9]+$";

    public boolean isEmptyInput(String input) {
        if (input == null || input.length() == 0)
            return true;
        return false;
    }

    public void illegalInputFilter(String input) {
        if (!input.matches(INPUT_REGEX)) {
            throw new RuntimeException("숫자 이외의 값 또는 음수는 사용할 수 없습니다.");
        }
    }
}
