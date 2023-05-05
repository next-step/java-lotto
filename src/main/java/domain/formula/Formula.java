package domain.formula;

import static domain.formula.Numbers.getNumbersByFormula;
import static domain.formula.Operators.getOperatorsByFormula;

import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class Formula {

    private Numbers numbers;
    private Operators operators;

    public static String FORMULA_VALIDATION_FAILED = "수식이 잘못 입력되었습니다.";

    public Formula(Numbers numbers, Operators operators) {
        this.numbers = numbers;
        this.operators = operators;
    }

    public static Formula getFormulaByInput(List<String> formula) {
        validateFormulaSize(formula);
        return new Formula(getNumbersByFormula(formula), getOperatorsByFormula(formula));
    }

    private static void validateFormulaSize(List<String> formula) {
        if (formulaSizeIsNotOdd(formula)) {
            throw new IllegalArgumentException(FORMULA_VALIDATION_FAILED);
        }
    }

    private static boolean formulaSizeIsNotOdd(List<String> formula) {
        return formula.size() % 2 == 0;
    }

    public Queue<Integer> numbers() {
        return numbers.getNumbersQueue();
    }

    public Queue<String> operators() {
        return operators.getOperatorsQueue();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Formula formula = (Formula) o;
        return Objects.equals(numbers, formula.numbers) && Objects.equals(operators,
                formula.operators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers, operators);
    }

    @Override
    public String toString() {
        return "Formula{" +
                "numbers=" + numbers +
                ", operators=" + operators +
                '}';
    }
}
