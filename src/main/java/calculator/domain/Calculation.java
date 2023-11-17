package calculator.domain;

public class Calculation {

    private final Numbers numbers;
    private final Operations operations;


    public Calculation(String[] textArray) {
        this.numbers = new Numbers(textArray);
        this.operations = new Operations(textArray);

    }

    public int startOperation() {
        int result = numbers.first();
        for (int i = 0; i < operations.size(); i++) {
            Operation operation = Operation.findOperationBySign(operations.findSign(i));
            result = operation.calculate(result, numbers.find(i + 1));
        }
        return result;

    }


}
