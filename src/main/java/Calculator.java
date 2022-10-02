public class Calculator {
    String input;

    public Calculator(String input) {
        if (isNullOfEmpty(input)) {
            this.input = input;
        }
    }

    public boolean isNullOfEmpty(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력 값이 null 이나 공백은 불가능합니다.");
        }
        return true;
    }
}
