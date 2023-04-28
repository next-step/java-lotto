package calculator.Model;

public class Number {
    private int number;

    public Number(String input) {
        if (isNumeric(input)) {
            this.number = Integer.parseInt(input);
            return;
        }

        throw new IllegalArgumentException("숫자가 아닙니다.");
    }

    public static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int value() {
        return number;
    }

    public Number plus(Number number) {
        return new Number(String.valueOf(this.number + number.value()));
    }

    public Number minus(Number number) {
        return new Number(String.valueOf(this.number - number.value()));
    }

    public Number multiple(Number number) {
        return new Number(String.valueOf(this.number * number.value()));
    }

    public Number divide(Number number) {
        return new Number(String.valueOf(this.number / number.value()));
    }
}
