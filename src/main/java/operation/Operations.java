package operation;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Operations {

    private Deque<Operation> operations;

    private Operations(Deque<Operation> operations) {
        this.operations = operations;
    }

    public static Operations defaultOf() {
        return new Operations(new LinkedList<>());
    }
    public static Operations defaultOf(List<String> operations) {
        Deque<Operation> operationList = new LinkedList<>();
        for (String operation: operations) {
            operationList.add(OperationFactory.make(operation));
        }
        return new Operations(operationList);
    }

    public int calculate(Deque<Integer> numbers) {
        int size = operations.size();
        for (int i = 0; i < size; i++) { // foreach 쓰면 java.util.ConcurrentModificationException 발생
            int first = 0;
            int second = 0;
            Operation operation = operations.pop();

            first = numbers.pop();
            second = numbers.pop();

            int result = operation.calculate(first, second);
            numbers.addFirst(result);
        }
        return numbers.pop();
    }

    public void add(String operationString) {
        Operation operation = OperationFactory.make(operationString);
        this.operations.addLast(operation);
    }

    public Operation nextOperation(){
        return operations.pop();
    }
}
