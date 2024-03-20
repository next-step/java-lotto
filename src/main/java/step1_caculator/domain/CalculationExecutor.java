package step1_caculator.domain;

import step1_caculator.type.OperatorType;

public class CalculationExecutor {
    private Operation operation;
    private OperatorType tempOperatorType;
    private int INITIAL_INT_VALUE = 0;

    public CalculationExecutor() {
        operation = new Operation();
    }
    public int getResult(){
        return operation.getResult();
    }
    public void calculate(int number) {

        if(this.operation.getResult() == INITIAL_INT_VALUE || tempOperatorType == null){
            this.operation.setResult(number);
            return;
        }

        if (tempOperatorType == OperatorType.PLUS) {
            this.operation.plus(number);
            return;
        }

        if (tempOperatorType == OperatorType.MINUS) {
            this.operation.minus(number);
            return;
        }

        if (tempOperatorType == OperatorType.DIVIDE) {
            this.operation.divide(number);
            return;
        }

        if (tempOperatorType == OperatorType.MULTIPLE) {
            this.operation.multiple(number);
            return;
        }
    }

    public void saveOperatorType(OperatorType operatorType) {
        this.tempOperatorType = operatorType;
    }

    public void resetOperatorType() {
        this.tempOperatorType = null;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "operation=" + operation +
                ", tempOperatorType=" + tempOperatorType +
                '}';
    }
}
