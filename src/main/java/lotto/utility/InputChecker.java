package lotto.utility;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputChecker {
    private static final String REGULAR_NUMBER = "^[0-9]{1,}$";
    private static final String REGULAR_OPERATORS = "^[+|\\-|*|/]$";
    private static final Pattern NUMBER_PATTERN_COMPILE = Pattern.compile(REGULAR_NUMBER);
    private static final Pattern OPERATOR_PATTERN_COMPILE = Pattern.compile(REGULAR_OPERATORS);

    public List<String> formulaToStrList(String formula) {

        return Arrays.asList(formula.trim().split(" "));
    }

    public void validFormula(List<String> formulaList) {
        throwRuntimeException(isNumberLastListValue(formulaList));

        int index = 0;
        for(String str : formulaList) {
            throwRuntimeException(validFormulaIndex(index, str));
            index ++;
        }
    }

    public boolean validFormulaIndex(int index, String str) {
        if(index%2 == 0) {
            return NUMBER_PATTERN_COMPILE.asMatchPredicate().test(str);
        }
        return OPERATOR_PATTERN_COMPILE.asMatchPredicate().test(str);
    }

    public boolean isNumberLastListValue(List<String> formulaList) {
        return NUMBER_PATTERN_COMPILE.asMatchPredicate().test(formulaList.get(formulaList.size()-1));
    }

    public void throwRuntimeException(boolean flag) {
        if(!flag) {
            throw new RuntimeException("연속으로 숫자 혹은 사칙연산자가 입력되었습니다.");
        }
    }

}
