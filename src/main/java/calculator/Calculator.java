package calculator;

public class Calculator {
    private Numbers numbers = new Numbers();
    private Operations operations = new Operations();

    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input is null or empty");
        }
        String[] splitInput = input.split(" ");
        checkSplitInput(splitInput);
        return sum();
    }

    private void checkSplitInput(String[] splitInput) {
        for (String element : splitInput) {
            addOperationAndNumber(element);
        }
    }

    private void addOperationAndNumber(String element) {
        if(!operations.isOperation(element) && !numbers.isNumber(element)) {
            throw new IllegalArgumentException("Check input operation");
        }
        operations.addIfOperation(element);
        numbers.addIfNumber(element);
    }

    private int sum() {
        int index = 0;
        int result = numbers.getNumberByIndex(index);
        for (Operation operation : operations.findAllOperation()) {
            index += 1;
            int nextNumber = numbers.getNumberByIndex(index);
            result = operation.apply(result, nextNumber);
        }
        return result;
    }

    public Numbers getNumbers() {
        return numbers;
    }

    public Operations getOperations() {
        return operations;
    }
}
