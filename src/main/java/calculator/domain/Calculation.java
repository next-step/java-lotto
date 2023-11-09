package calculator.domain;

public class Calculation {

    private final NumberList numberList;
    private final OperationList operationList;


    public Calculation(String[] textArray) {
        this.numberList = new NumberList(textArray);
        this.operationList = new OperationList(textArray);

    }

    public int startOperation() {
        int result = numberList.getNumberList().get(0);
        for (int i = 0; i < operationList.getOperationList().size(); i++) {
            Operation operation = Operation.findOperationBySign(operationList.getOperationList().get(i));
            result = operation.calculate(result, numberList.getNumberList().get(i+1));
        }
        return result;

    }



}
