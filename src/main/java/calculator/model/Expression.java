package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Expression {
    private final List<String> tokens;
    private static final Pattern VAILD_SYMBOL_PATTERN = Pattern.compile("^[0-9+\\-*/\\s]*$");
    private static final Pattern CONSECUTIVE_OPERATOR_PATTERN = Pattern.compile(".*[+\\-*/]{2,}.*");
    private static final Pattern FRONT_POSITIVE_NUMBER_PATTERN = Pattern.compile("^\\d.*");
    private static final Pattern FRONT_NEGATIVE_NUMBER_PATTERN = Pattern.compile("^-\\d.*");
    private static final Pattern BACK_NUMBER_PATTERN = Pattern.compile(".*\\d$");
    private static final String ERR_EMPTY_EXPRESSION = "Empty input values are not allowed.";
    private static final String ERR_INVALID_SYMBOL = "Only the following symbols can be used: " + Operator.getAllSymbols();
    private static final String ERR_INVALID_EXPRESSION = "Expression is not valid.";

    public Expression(String expression) {
        // validate
        Expression.validate(expression);

        this.tokens = split(expression);
    }

    public Expression(List<String> tokens) {
        // validate
        Expression.validate(String.join(" ", tokens));

        this.tokens = tokens;
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
        return !VAILD_SYMBOL_PATTERN.matcher(expression).matches();
    }

    private static boolean checkNumberOnEdge(String expression) {
        expression = expression.trim();
        if ((FRONT_POSITIVE_NUMBER_PATTERN.matcher(expression).matches()
                || FRONT_NEGATIVE_NUMBER_PATTERN.matcher(expression).matches())
                && BACK_NUMBER_PATTERN.matcher(expression).matches()) {
            return true;
        }
        return false;
    }

    private static boolean containsConsecutiveOperators(String expression) {
        return CONSECUTIVE_OPERATOR_PATTERN.matcher(
                expression.replaceAll("\\s", "")
        ).matches();
    }

    private static ArrayList<String> split(String expression) {
        String[] splitArray = expression.trim().split("\\s+");
        return new ArrayList<>(Arrays.asList(splitArray));
    }

    public Binomial popBinomial() {
        String leftNumber = this.tokens.remove(0);
        String operator = this.tokens.remove(0);
        String rightNumber = this.tokens.remove(0);
        return new Binomial(List.of(leftNumber, operator, rightNumber));
    }

    public boolean isNotMonomial() {
        if (this.tokens.size() == 1) {
            return false;
        }
        return true;
    }

    public int getResult() {
        return Integer.parseInt(this.tokens.get(0));
    }

    public List<String> tokens() {
        return this.tokens;
    }
}
