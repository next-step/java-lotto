import java.util.*;
import java.util.function.IntBinaryOperator;

public class Calculator {

    private static final Map<String, IntBinaryOperator> OPERATOR_MAP = Map.of("+", (a, b) -> a + b, "-", (a, b) -> a - b, "/", (a, b) -> a / b, "*", (a, b) -> a * b);

    private final List<String> numbersAndOps;

    public Calculator(String[] numbersAndOps) {
        validateArgument(numbersAndOps);
        this.numbersAndOps = new ArrayList<>(Arrays.asList(numbersAndOps));
    }

    public int calculate() {
        Deque<Integer> numbers = new LinkedList<>();
        Deque<String> operators = new LinkedList<>();
        while (!numbersAndOps.isEmpty()) {
            String unit = numbersAndOps.remove(0);
            pushNumberOrOperator(numbers, operators, unit);
        }

        while (!operators.isEmpty()) {
            String operator = operators.pollFirst();
            int right = numbers.pollFirst();
            int left = numbers.pollFirst();
            int calculateResult = calculateOperation(left, right, operator);
            numbers.addFirst(calculateResult);
        }

        return numbers.pop();
    }

    private void pushNumberOrOperator(Deque<Integer> numbers, Deque<String> operators, String unit) {
        if (isOperator(unit)) {
            operators.push(unit);
            return;
        }
        numbers.push(toInt(unit));
    }

    private void validateArgument(String[] numbersAndOps) {
        if (numbersAndOps.length == 0 || Arrays.stream(numbersAndOps).anyMatch(String::isBlank)) {
            throw new IllegalArgumentException("array is empty or not valid element");
        }
    }

    private int toInt(String unit) {
        try {
            return Integer.parseInt(unit);
        } catch (Exception ex) {
            throw new IllegalArgumentException("convert failed to number");
        }
    }

    private int calculateOperation(int left, int right, String operator) {
        IntBinaryOperator operateFunction = OPERATOR_MAP.get(operator);
        return operateFunction.applyAsInt(left, right);
    }

    private boolean isOperator(String unit) {
        return OPERATOR_MAP.containsKey(unit);
    }
}
