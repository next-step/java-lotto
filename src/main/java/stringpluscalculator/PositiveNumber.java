package stringpluscalculator;

public class PositiveNumber {
    private Integer positiveNumber;

    public PositiveNumber(Integer number) {
        validatePositive(number);
        this.positiveNumber = number;
    }

    public PositiveNumber(String number) {
        this.positiveNumber = convertNumber(number);
        validatePositive(this.positiveNumber);
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

    private void validatePositive(int number) {
        if (number < 0) {
            throw new RuntimeException("양수가 아닙니다.");
        }
    }
}
