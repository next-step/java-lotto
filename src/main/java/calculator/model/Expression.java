package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Expression {
    private final List<String> tokens;
    private static final String ERR_EMPTY_EXPRESSION = "Empty input values are not allowed.";
    private static final String ERR_INVALID_SYMBOL = "Only the following symbols can be used: " + Operator.getAllSymbols();
    private static final String ERR_INVALID_EXPRESSION = "Expression is not valid.";

    public Expression(String expression) {
        // validate
        Expression.validate(expression);

        this.tokens = split(expression);
    }

    public static void validate(String expression) {
        if (expression == null || expression.isBlank()) {
            throw new IllegalArgumentException(ERR_EMPTY_EXPRESSION);
        }

        if (containsInvalidSymbol(expression) || containsConsecutiveOperators(expression)) {
            throw new IllegalArgumentException(ERR_INVALID_SYMBOL);
        }

        if (!checkNumberOnEdge(expression)) {
            throw new IllegalArgumentException(ERR_INVALID_EXPRESSION);
        }
    }

    private static boolean containsInvalidSymbol(String expression) {
        String regex = "^[0-9+\\-*/\\s]*$";
        return !Pattern.matches(regex, expression);
    }

    private static boolean checkNumberOnEdge(String expression) {
        expression = expression.trim();
        if ((Pattern.matches("^\\d.*", expression)
                || Pattern.matches("^-\\d.*", expression))
                && Pattern.matches(".*\\d$", expression)) {
            return true;
        }
        return false;
    }

    private static boolean containsConsecutiveOperators(String expression) {
        String regex = ".*[+\\-*/]{2,}.*";
        return Pattern.matches(regex, expression.replaceAll("\\s", ""));
    }

    public static ArrayList<String> split(String expression) {
        String[] splitArray = expression.trim().split("\\s+");
        return new ArrayList<>(Arrays.asList(splitArray));
    }

    public Binomial popBinomial() {
        String leftNumber = this.tokens.remove(0);
        String operator = this.tokens.remove(0);
        String rightNumber = this.tokens.remove(0);
        return new Binomial(List.of(leftNumber, operator, rightNumber));
    }

    public boolean isMonomial() {
        if (this.tokens.size() == 1) {
            return true;
        }
        return false;
    }

    public void addToFront(int number) {
        this.tokens.add(0, String.valueOf(number));
    }

    public int getResult() {
        return Integer.parseInt(this.tokens.get(0));
    }
}
