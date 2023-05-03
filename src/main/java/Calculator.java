import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Calculator {
    private static final String DELIMITER = " ";

    private static void isValid(String inputVal) {
        if (Objects.isNull(inputVal)
            || inputVal.isBlank()) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다.");
        }
    }

    public static int calculate(String input) {
        isValid(input);
        Queue<String> queue = createQueue(input);

        Number number = getInitialNumber(queue);
        while (queue.size() > 0) {
            calculateByOperator(queue, number);
        }
        return number.getAnswer();
    }

    private static Number getInitialNumber(Queue<String> queue) {
        String start = queue.poll();
        Number number = Number.ofNumber(start);
        return number;
    }

    private static Queue<String> createQueue(String input) {
        String[] result = input.split(DELIMITER);
        Queue<String> queue = new LinkedList<>();
        Collections.addAll(queue, result);
        return queue;
    }

    private static void calculateByOperator(Queue<String> queue, Number number) {
        String signature = queue.poll();
        Operator operator = Operator.fromSignature(signature);
        operator.performOperation(queue, number);
    }
}
