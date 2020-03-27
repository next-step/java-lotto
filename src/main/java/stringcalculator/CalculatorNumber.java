package stringcalculator;

public class CalculatorNumber {
    private static final int DEFAULT_NUMBER = 0;
    private final int number;

    public CalculatorNumber(String numberString) {
        this(Integer.parseInt(numberString));
    }

    public CalculatorNumber(int number) {
        this.number = number;
        validate();
    }

    private void validate() {
        if (number < DEFAULT_NUMBER) {
            throw new IllegalArgumentException("기본값은 음수가 될 수 없습니다.");
        }
    }

    public int getNumber() {
        return number;
    }

    public CalculatorNumber add(CalculatorNumber calculatorNumber) {
        return new CalculatorNumber(number + calculatorNumber.getNumber());
    }
}
