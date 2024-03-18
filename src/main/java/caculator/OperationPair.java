package caculator;

public class OperationPair {
    private final OperatorType operatorType;
    private final Number number;

    public OperationPair(OperatorType operatorType, Number number) {
        this.operatorType = operatorType;
        this.number = number;
    }

    public OperationPair(String operatorType, String number) {
        this.number = new Number(number);
        this.operatorType = OperatorType.findByValue(operatorType);
    }


    public OperatorType getOperatorType(){
        return this.operatorType;
    }

    public Number getNumber() {
        return this.number;
    }
}
