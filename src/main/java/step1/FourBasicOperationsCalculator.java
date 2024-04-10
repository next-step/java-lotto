package step1;

import static step1.common.constants.*;

public class FourBasicOperationsCalculator {

    private int result;

    public int result() {
        return this.result;
    }

    public void calculate(String question) {
        if (question == null) throw new IllegalArgumentException();
        String[] operation = question.split(EMPTY_STRING);
        if (operation.length < 3) throw new IllegalArgumentException();
        int operand1 = Integer.parseInt(operation[0]);
        int operand2 = Integer.parseInt(operation[2]);
        String operator = operation[1];
        switch (operator) {
            case OPERATION_ADDITION:
                this.result = operand1 + operand2;
                break;
            case OPERATION_SUBSTRACTION:
                this.result = operand1 - operand2;
                break;
            case OPERATION_MULTIPLICATION:
                this.result = operand1 * operand2;
                break;
            case OPERATION_DIVISION:
                this.result = operand1 / operand2;
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

}
