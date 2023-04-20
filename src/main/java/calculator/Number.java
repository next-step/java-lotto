package calculator;

public class Number {

    private final int num;

    public Number(String input) {
        if(isNotNumeric(input)) {
            throw new NumberFormatException("숫자가 아닙니다.");
        }
        this.num = parseInt(input);
    }

    int parseInt(String input) {
        return Integer.parseInt(input);
    }

    public int intValue() {
        return num;
    }

    boolean isNotNumeric(String s) {
        return !s.chars().allMatch(Character::isDigit);
    }
}
