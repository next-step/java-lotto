package lotto.utility;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputChecker {
    private static final Pattern NUMBER_PATTERN_COMPILE = Pattern.compile("^[0-9]{1,}$");
    private static final Pattern OPERATOR_PATTERN_COMPILE = Pattern.compile("^[+|\\-|*|/]$");

    public List<String> formulaToStrList(String formula) {

        return Arrays.asList(formula.trim().split(" "));
    }

    public void validFormula(List<String> formulaList) {
        this.isThrowIllegalArgumentException(this.isNumberLastListValue(formulaList));

        for(int i = 0; i<formulaList.size(); i++) {
            this.isThrowIllegalArgumentException(this.validFormulaIndex(i, formulaList.get(i)));
        }
    }

    private boolean validFormulaIndex(int index, String str) {
        if(index%2 == 0) {
            return NUMBER_PATTERN_COMPILE.asMatchPredicate().test(str);
        }
        return OPERATOR_PATTERN_COMPILE.asMatchPredicate().test(str);
    }

    private boolean isNumberLastListValue(List<String> formulaList) {
        return NUMBER_PATTERN_COMPILE.asMatchPredicate().test(formulaList.get(formulaList.size()-1));
    }

    private void isThrowIllegalArgumentException(boolean flag) {
        if(!flag) {
            throw new IllegalArgumentException ("연속으로 숫자 혹은 사칙연산자가 입력되었습니다.");
        }
    }

}
