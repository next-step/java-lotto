import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Calculator {

    private static final int ZERO = 0;
    private static final String DELIMITER = " ";

    private static final String

    private static void isValid(String inputVal) {
        if (inputVal.isBlank()) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다.");
        }
    }

    public static int calculate(String input) {
        isValid(input);
        Queue<String> queue = createQueue(input);

        int answer = getInitialValue(queue);
        while (queue.size() > 0) {
            answer = calculateByOperator(queue, answer);
        }
        return answer;
    }

    private static int getInitialValue(Queue<String> queue) {
        int initialValue = ZERO;
        String start = queue.poll();
        if (IntConverter.isConvertibleToInt(start)) {
            initialValue = IntConverter.convertStringToInt(start);
        }
        return initialValue;
    }

    private static Queue<String> createQueue(String input) {
        String[] result = input.split(DELIMITER);
        Queue<String> queue = new LinkedList<>();
        Collections.addAll(queue, result);
        return queue;
    }

    private static int calculateByOperator(Queue<String> queue, int answer) {
        String signature = queue.poll();
        isOperator(signature);
        Operator operator = Operator.fromSignature(signature);
        return operator.performOperation(queue, answer);
    }

    private static void isOperator(String signature) {
        if (IntConverter.isConvertibleToInt(signature)) {
            throw new IllegalArgumentException("값이 잘못 입력되었습니다.");
        }
    }
}
