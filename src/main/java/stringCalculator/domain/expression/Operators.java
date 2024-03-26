package stringCalculator.domain.expression;

import java.util.LinkedList;
import java.util.Queue;

public class Operators {

    private final Queue<String> operators = new LinkedList<>();

    private final String numericalExpression = "+-*/" ;

    public void add(String operator) {
        operators.add(operator);
    }

    public String poll() {
        return operators.poll();
    }

    public int size() {
        return operators.size();
    }

    public boolean isContainNumericalExpression(String operator) {
        return numericalExpression.contains(operator);
    }

    public boolean isEmpty() {
        return operators.isEmpty();
    }
}
