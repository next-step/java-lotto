package lotto;

import lotto.utility.InputChecker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

public class regExTest {

    @Test
    @DisplayName("입력받은 문자열 앞뒤 공백 제거 후 빈 공백으로 split 하여 짝수 index -> 숫자, 홀수 index -> 연산자 되도록 구분")
    public void formulaToStrList() {
        String testInput = " 44 + 55 - 2 / 5 ";
        InputChecker inputChecker = new InputChecker();

        List<String> result = inputChecker.formulaToStrList(testInput);

        // 짝수 index -> 숫자
        assertThat(result.get(0)).isEqualTo("44");
        assertThat(result.get(2)).isEqualTo("55");
        assertThat(result.get(4)).isEqualTo("2");
        assertThat(result.get(6)).isEqualTo("5");

        // 홀수 index -> 연산자
        assertThat(result.get(1)).isEqualTo("+");
        assertThat(result.get(3)).isEqualTo("-");
        assertThat(result.get(5)).isEqualTo("/");
    }


    @Test
    @DisplayName("입력받은 문자열을 빈 공백으로 split할 경우 index가 짝수이면 숫자, 홀수이면 사칙연산자를 구분")
    public void ValidFormulaIndexTest() {
        InputChecker inputChecker = new InputChecker();

        boolean result = inputChecker.ValidFormulaIndex(0, "5");    // 숫자 index: 숫자
        boolean result2 = inputChecker.ValidFormulaIndex(2, "55");    // 숫자 index: 2자리 이상
        boolean result3 = inputChecker.ValidFormulaIndex(0, "");    // 숫자 index: 미입력
        boolean result4 = inputChecker.ValidFormulaIndex(2, "-");    // 숫자 index: 숫자 외 입력
        boolean result5 = inputChecker.ValidFormulaIndex(1, "-");   // 연산자 index: 연산자
        boolean result6 = inputChecker.ValidFormulaIndex(1, "+-");   // 연산자 index: 연산자 여러개
        boolean result7 = inputChecker.ValidFormulaIndex(3, "123");   // 연산자 index: 연산자 외 입력

        assertThat(result).isTrue();
        assertThat(result2).isTrue();
        assertThat(result3).isFalse();
        assertThat(result4).isFalse();
        assertThat(result5).isTrue();
        assertThat(result6).isFalse();
        assertThat(result7).isFalse();

    }
}
