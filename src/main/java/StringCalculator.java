import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    private static final String ADD = "+";
    private static final String SUBTRACT = "-";
    private static final String DIVIDE = "/";
    private static final String MULTIPLY = "*";

    private final List<String> expression = new ArrayList<>();
    private int result = 0;

    public StringCalculator(InputValue inputValue) {
        this.expression.addAll(inputValue.getExpression());
    }

    public int Calculate(String input) {
        for (int i = 0; i < expression.size(); i++) {
            result = add(result, i);
            result = subtract(result, i);
            result = multiply(result, i);
            result = divide(result, i);
        }
        return result;
    }

    private int divide(int result, int i) {
        if (isContains(i, DIVIDE)) {
            result = parseInt(i - 1) / parseInt(i + 1);
            replaceResult(result, i);
        }
        return result;
    }


    private int multiply(int result, int i) {
        if (isContains(i, MULTIPLY)) {
            result = parseInt(i - 1) * parseInt(i + 1);
            replaceResult(result, i);
        }
        return result;
    }


    private int subtract(int result, int i) {
        if (isContains(i, SUBTRACT)) {
            result = parseInt(i - 1) - parseInt(i + 1);
            replaceResult(result, i);
        }
        return result;
    }

    private int add(int result, int i) {
        if (isContains(i, ADD)) {
            result = parseInt(i - 1) + parseInt(i + 1);
            replaceResult(result, i);
        }
        return result;
    }

    private String replaceResult(int result, int i) {
        return expression.set(i + 1, convertString(result));
    }
    private boolean isContains(int i, String operator) {
        return expression.get(i).contains(operator);
    }

    private static String convertString(int result) {
        return Integer.toString(result);
    }

    private int parseInt(int i) {
        return Integer.parseInt(expression.get(i));
    }

}
