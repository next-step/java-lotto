import java.util.*;

public class Calculator {

    private final List<String> numbersAndOps;

    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String DIVIDE = "/";
    private static final String MULTIPLY = "*";

    public Calculator(String[] numbersAndOps) {
        validateArgument(numbersAndOps);
        this.numbersAndOps = new ArrayList<>(Arrays.asList(numbersAndOps));
    }

    public int calculate() {
        Deque<Integer> numbers = new LinkedList<>();
        Deque<String> operators = new LinkedList<>();
        while (!numbersAndOps.isEmpty()) {
            String unit = numbersAndOps.remove(0);
            if (isOperator(unit)) {
                operators.push(unit);
                continue;
            }
            numbers.push(toInt(unit));
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
        switch (operator) {
            case PLUS:
                return left + right;
            case MINUS:
                return left - right;
            case DIVIDE:
                return left / right;
            case MULTIPLY:
                return left * right;
            default:
                throw new IllegalArgumentException();
        }
    }

    private boolean isOperator(String unit) {
        return unit.equals(PLUS) || unit.equals(MINUS) || unit.equals(DIVIDE) || unit.equals(MULTIPLY);
    }
}
