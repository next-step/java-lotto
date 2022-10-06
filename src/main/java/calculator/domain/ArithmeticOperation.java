package calculator.domain;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticOperation {
    private static Map<String, Operation> operationMap = initOperation();

    private ArithmeticOperation() {
    }

    private static Map<String, Operation> initOperation(){
        Map<String, Operation> operationMap = new HashMap<>();

        operationMap.put("+", new PlusOperationImpl());
        operationMap.put("-", new MinusOperationImpl());
        operationMap.put("*", new MultipleOperationImpl());
        operationMap.put("/", new DivisionOperationImpl());

        return operationMap;
    }

    public static Operation getOperation(String sign){
        return operationMap.get(sign);
    }

    public static boolean hasOperation(String sign){
        return operationMap.containsKey(sign);
    }
}
