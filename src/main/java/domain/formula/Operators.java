package domain.formula;

import static domain.Operator.validateOperatorSymbol;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Operators {

    private final List<String> operators;

    public Operators(List<String> operators) {
        validateOperatorSymbol(operators);
        this.operators = operators;
    }

    public static Operators getOperatorsByFormula(List<String> formula) {
        return new Operators(makeOperatorWithOddElements(formula));
    }

    private static List<String> makeOperatorWithOddElements(List<String> formula) {
        List<String> operators = new ArrayList<>();

        for (int i = 0; i < formula.size(); i++) {
            oddElementToOperators(formula, operators, i);
        }
        return operators;
    }

    private static void oddElementToOperators(List<String> formula, List<String> operators, int i) {
        if (i % 2 == 1) {
            operators.add(formula.get(i));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Operators operators1 = (Operators) o;
        return Objects.equals(operators, operators1.operators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operators);
    }

    @Override
    public String toString() {
        return "Operators{" +
                "operators=" + operators +
                '}';
    }
}
