package domain;

import java.util.List;

public class Formula {

    private final List<String> formula;

    public Formula(List<String> formula) {
        validateFormula(formula);
        this.formula = formula;
    }

    private void validateFormula(List<String> formula) {
        /**
         * 앞, 뒤가 숫자일 것
         * 숫자 뒤에 기호가 올 것
         */
    }
}
