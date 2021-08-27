package calculator;

public class Number {

    private final int number;

    public Number(String number) {
        checkNotNumber(number);
        this.number = Integer.parseInt(number);
    }

    private void checkNotNumber(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new RuntimeException();
        }
    }

    public int number() {
        return number;
    }

}
