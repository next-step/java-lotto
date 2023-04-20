package calculator.domain;

public class Number {

    private int number;

    public Number(String input) {
        if(isNullOrEmpty(input)) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
        if(isNotNumeric(input)) {
            throw new NumberFormatException("숫자가 아닙니다.");
        }
        this.number = parseInt(input);
    }

    public int intValue() {
        return number;
    }

    public int plus(Number number) {
        this.number += number.intValue();
        return this.number;
    }

    public int minus(Number number) {
        this.number -= number.intValue();
        return this.number;
    }

    public int multiply(Number number) {
        this.number *= number.intValue();
        return this.number;
    }

    public int divide(Number number) {
        this.number /= number.intValue();
        return this.number;
    }

    boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    boolean isNotNumeric(String s) {
        return !s.chars().allMatch(Character::isDigit);
    }

    int parseInt(String input) {
        return Integer.parseInt(input);
    }
}
