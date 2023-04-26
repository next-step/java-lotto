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

        int index = 0;
        for(String str : formulaList) {
            if(ValidFormulaIndex(index, str)) {
                throw new RuntimeException("연속으로 숫자 혹은 사칙연산자가 입력되었습니다.");
            };
            index ++;
        }
    }

    public boolean ValidFormulaIndex(int index, String str) {
        if(index%2 == 0) {
            return NUMBER_PATTERN_COMPILE.asMatchPredicate().test(str);
        }
        return OPERATOR_PATTERN_COMPILE.asMatchPredicate().test(str);
    }

}
