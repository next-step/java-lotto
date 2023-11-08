package calculator.domain;

import java.util.List;

public class OperationManager {

    private OperationManager() {
    }

    public static int opertaion(String input) {
        List<String> operations = StringSplitter.splitOperation(input);
        List<Integer> numbers = StringSplitter.splitNumbers(input);

        int basicNumber = numbers.get(0);
        for(int i = 0; i < operations.size(); i++) {
            Operation operation = Operation.searchBy(operations.get(i));
            basicNumber = operation.calculate(basicNumber, numbers.get(i + 1));
        }

        return basicNumber;
    }
}
