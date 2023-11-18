package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Expression {
    private final List<String> tokens;

    public Expression(String expression) {
        // validate
        ExpressionValidator.validate(expression);

        this.tokens = split(expression);
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
