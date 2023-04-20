package calculator;

public class Number {

    private final int number;

    public Number(String input) {
        if(isNotNumeric(input)) {
            throw new NumberFormatException("숫자가 아닙니다.");
        }
        this.number = parseInt(input);
    }

    int parseInt(String input) {
        return Integer.parseInt(input);
    }

    public int intValue() {
        return number;
    }

    boolean isNotNumeric(String s) {
        return !s.chars().allMatch(Character::isDigit);
    }
}
