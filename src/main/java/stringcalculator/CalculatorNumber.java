package stringcalculator;

public class CalculatorNumber {
    private static final int DEFAULT_NUMBER = 0;
    private int number;

    public CalculatorNumber(String numberString) {
        this.number = Integer.parseInt(numberString);
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

    public void add(CalculatorNumber calculatorNumber) {
        number += calculatorNumber.getNumber();
    }
}
