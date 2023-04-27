package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputConverter {
    private static final Pattern NUMBER_PATTERN_COMPILE = Pattern.compile("^[0-9]{1,}$");

    public List<String> formulaToStrList(String formula) {
        List<String> formulaList = Arrays.asList(formula.trim().split(" "));
        this.isThrowIllegalArgumentException(formulaList);

        return formulaList;
    }

    private boolean isLastWordNumber(List<String> formulaList) {
        return NUMBER_PATTERN_COMPILE.asMatchPredicate().test(formulaList.get(formulaList.size()-1));
    }

    private void isThrowIllegalArgumentException(List<String> formulaList) {
        if(!this.isLastWordNumber(formulaList)) {
            throw new IllegalArgumentException ("마지막 입력값이 숫자가 아닙니다.");
        }
    }

}
