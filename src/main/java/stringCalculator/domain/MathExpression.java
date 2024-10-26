package stringCalculator.domain;

import java.util.List;
import java.util.Queue;

public class MathExpression {
    private final Queue<Integer> numbers;
    private final Queue<String> operations;

    MathExpression(Queue<Integer> numbers, Queue<String> operations) {
        this.numbers = numbers;
        this.operations = operations;
    }

    public Boolean numbersContains(List<Integer> contains) {
        return numbers.containsAll(contains);
    }

    public Boolean operationsContains(List<String> contains) {
        return operations.containsAll(contains);
    }

    public Integer numberPoll(){
        return numbers.poll();
    }

    public String operationPoll(){
        return operations.poll();
    }

    public Boolean numberHasNext(){
        return numbers.iterator().hasNext();
    }

    public Boolean operationHasNext(){
        return operations.iterator().hasNext();
    }
}
