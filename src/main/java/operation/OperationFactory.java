package operation;

import operation.implemantation.DivideOperation;
import operation.implemantation.MinusOperation;
import operation.implemantation.MultiplyOperation;
import operation.implemantation.PlusOperation;

import java.util.HashMap;
import java.util.Map;

public class OperationFactory {

    private static final Map<String,Operation> operations = new HashMap<>();

    static {
        operations.put("+", new PlusOperation());
        operations.put("-", new MinusOperation());
        operations.put("*", new MultiplyOperation());
        operations.put("/", new DivideOperation());

    }

    public static int calculateRightNow(int result, int number, String stringOperation) {
        return operations.get(stringOperation).calculate(result,number);
    }
}
