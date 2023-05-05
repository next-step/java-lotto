package domain.formula;

import java.util.ArrayList;
import java.util.List;

public class Operators {

    private final List<String> operators;

    public Operators(List<String> operators) {
        this.operators = operators;
    }

    public static Operators getOperatorsByFormula(List<String> formula) {
        List<String> operators = new ArrayList<>();
        makeOperatorWithOddElements(formula, operators);
        return new Operators(operators);
    }

    private static void makeOperatorWithOddElements(List<String> formula, List<String> operators) {
        for (int i = 0; i < formula.size() / 2; i++) {
            operators.add(formula.get(i * 2 + 1));
        }
    }
}
