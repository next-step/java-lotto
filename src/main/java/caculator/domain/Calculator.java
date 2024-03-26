package caculator.domain;

public class Calculator {
    private int result;
    private String tmpOperation;
    static final private int INITIAL_INT_VALUE = 0;

    public Calculator(
            int result,
            String tmpOperation
    ) {
        this.result = result;
        this.tmpOperation = tmpOperation;
    }

    public int calculate(int number) {

        if(this.result == INITIAL_INT_VALUE || tmpOperation == null){
            this.result = number;
            return this.result;
        }

        IntOperator operator = IntOperator.findOperationByValue(tmpOperation);
        return result = operator.calculate(result, number);
    }

    public void saveOperation(String tmpOperation) {
        this.tmpOperation = tmpOperation;
    }

    public void resetOperation() {
        this.tmpOperation = null;
    }
}
