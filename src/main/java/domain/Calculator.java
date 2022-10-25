package domain;

public class Calculator {

    private int tempResult;
    private String[] inputValues;

    public Calculator(String[] inputValues) {
        this.inputValues = inputValues;
        this.tempResult = Integer.parseInt(inputValues[0]);
    }

    public Calculator(int number) {
        this.tempResult = number;
    }

    public void calculateAll() {
        for (int i = 1; i < inputValues.length; i += 2) {
            calculate(inputValues[i], Integer.parseInt(inputValues[i + 1]));
        }
        
    }

    private void calculate(String operand, int number) {
        if (operand.equals("+")) {
            add(number);
        }
        if (operand.equals("-")) {
            minus(number);
        }
        if (operand.equals("*")) {
            multiple(number);
        }
        if (operand.equals("/")) {
            divide(number);
        }
    }

    public void add(int number) {
        tempResult += number;
    }

    public void minus(int number) {
        tempResult -= number;
    }

    public void multiple(int number) {
        tempResult *= number;
    }

    public void divide(int number) {
        tempResult /= number;
    }

    public int printResult() {
        return this.tempResult;
    }
}
