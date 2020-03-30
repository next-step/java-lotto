package stringpluscalculator;

public class PositiveNumber {
    private Integer positiveNumber;

    public PositiveNumber(Integer number) {
        validatePositiveOrZero(number);
        this.positiveNumber = number;
    }

    public PositiveNumber(String number) {
        this.positiveNumber = convertNumber(number);
        validatePositiveOrZero(this.positiveNumber);
    }

    public Integer getPositiveNumber() {
        return this.positiveNumber;
    }

    private Integer convertNumber(String input) {
        Integer number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            throw new RuntimeException("숫자가 아닙니다.");
        }
        return number;
    }

    private void validatePositiveOrZero(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 사용할 수 없습니다.");
        }
    }
}
