package calculator.domain;

public class Calculator {

    private final InputNumber inputNumber;

    public Calculator(InputNumber inputNumber) {
        this.inputNumber = inputNumber;
    }

    public int calculate() {
        if (inputNumber.isEmpty()) {
            return 0;
        }
        return inputNumber.getNumbers();
    }
}
