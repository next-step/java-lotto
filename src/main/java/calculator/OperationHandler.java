package calculator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import static calculator.ErrorMessage.*;

public class OperationHandler {
    private static final Set<String> OPERATION_SET = Set.of("+", "-", "*", "/");
    private Queue<String> operations;
    public OperationHandler(String[] operationArrays){
        this.operations=new LinkedList<>();
        for (String operation : operationArrays) {
            operations.add(operation);
        }
    }

    public int calculate(){
        int calc= convertStringToInt(operations.poll());
        while (!operations.isEmpty()){
            validateCalcSize(operations);
            Operation operation = new Operation(calc, validateOperationSymbol(operations.poll()), convertStringToInt(operations.poll()));
            calc = operation.execute();
        }
        return calc;
    }

    private void validateCalcSize(Queue<String> queue){
        if(queue.size()<2){
            throw new IllegalArgumentException(NOTHING_TO_CACULATE);
        }
    }

    private int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(INPUT_IS_NOT_NUMBER);
        }
    }

    private String validateOperationSymbol(String input) {
        if (!OPERATION_SET.contains(input)) {
            throw new IllegalArgumentException(INPUT_IS_NOT_OPERATOR_SYMBOL);
        }
        return input;
    }
}
