package domain.formula;

import static domain.formula.Numbers.getNumbersByFormula;
import static domain.formula.Operators.getOperatorsByFormula;

import java.util.List;

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

}
