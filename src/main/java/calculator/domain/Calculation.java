package calculator.domain;

public class Calculation {

    private final Numbers numberList;
    private final Operations operationList;


    public Calculation(String[] textArray) {
        this.numberList = new Numbers(textArray);
        this.operationList = new Operations(textArray);

    }

    public int startOperation() {
        int result = numberList.findNumber(0);
        for (int i = 0; i < operationList.size(); i++) {
            Operation operation = Operation.findOperationBySign(operationList.findSign(i));
            result = operation.calculate(result, numberList.findNumber(i + 1));
        }
        return result;

    }


}
