package lotto;

import lotto.utility.InputChecker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

public class regExTest {

    @Test
    @DisplayName("입력받은 문자열을 빈 공백으로 split할 경우 index가 짝수이면 숫자, 홀수이면 사칙연산자를 구분")
    public void splitFormula() {

        InputChecker inputChecker = new InputChecker();

        boolean result = inputChecker.ValidFormulaIndex(0, "5");    // 숫자 index: 한자리 숫자
        boolean result2 = inputChecker.ValidFormulaIndex(1, "-");   // 연산자 index: "-"
        boolean result3 = inputChecker.ValidFormulaIndex(2, "-");   // 숫자 index: 연산자
        boolean result4 = inputChecker.ValidFormulaIndex(3, "-");   // 연산자 index: "+-"

        assertThat(result).isTrue();
        assertThat(result2).isTrue();
        assertThat(result3).isFalse();
        assertThat(result4).isFalse();


//        for(String str : formulaList) {
//
//        }
//
//        formulaList.stream()
//                .map(str -> {
//                    // number
//                    if(formulaList.indexOf(str)%2 == 0) {
//                        return str.matches(regExNumber);
//                    }
//
//                });

    }
}
