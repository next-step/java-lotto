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
        this.result = Integer.parseInt(operation[0]);
        for (int i=0; i<operation.length-2; i=i+2) operate(operation, i);
    }

    private void operate(String[] operation, int step) {
        int operand = Integer.parseInt(operation[step+2]);
        String operator = operation[step+1];
        subOperate(operand, operator);
    }

    private void subOperate(int operand, String operator) {
        /* TODO: depth 가 2 미만이 되게 하려면 switch 문은 사용하지 않아야 하는 건지 이해 필요 */
        switch (operator) {
            case OPERATION_ADDITION:
                this.result += operand;
                break;
            case OPERATION_SUBSTRACTION:
                this.result -= operand;
                break;
            case OPERATION_MULTIPLICATION:
                this.result *= operand;
                break;
            case OPERATION_DIVISION:
                this.result /= operand;
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

}
