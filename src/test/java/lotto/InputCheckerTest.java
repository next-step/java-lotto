package lotto;

import lotto.utility.InputChecker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

public class InputCheckerTest {

    @Test
    @DisplayName("입력받은 문자열 앞뒤 공백 제거 후 빈 공백으로 split 하여 짝수 index -> 숫자, 홀수 index -> 연산자 되도록 구분")
    public void formulaToStrListTest() {
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

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    @DisplayName("입력받은 문자열이 빈 공백일 때 확인")
    public void formulaToStrListTest2() {
        String test = "";
        InputChecker inputChecker = new InputChecker();

        List<String> result2 = inputChecker.formulaToStrList(test);

        assertThat(result2.get(0)).isEqualTo("");
    }


    @Test
    @DisplayName("입력받은 문자열을 빈 공백으로 split할 경우 index가 짝수이면 숫자, 홀수이면 사칙연산자를 구분")
    public void validFormulaIndexTest() {
        InputChecker inputChecker = new InputChecker();

        boolean result = inputChecker.validFormulaIndex(0, "5");    // 숫자 index: 숫자
        boolean result2 = inputChecker.validFormulaIndex(2, "55");    // 숫자 index: 2자리 이상
        boolean result3 = inputChecker.validFormulaIndex(0, "");    // 숫자 index: 미입력
        boolean result4 = inputChecker.validFormulaIndex(2, "-");    // 숫자 index: 숫자 외 입력
        boolean result5 = inputChecker.validFormulaIndex(1, "-");   // 연산자 index: 연산자
        boolean result6 = inputChecker.validFormulaIndex(1, "+-");   // 연산자 index: 연산자 여러개
        boolean result7 = inputChecker.validFormulaIndex(3, "123");   // 연산자 index: 연산자 외 입력

        assertThat(result).isTrue();
        assertThat(result2).isTrue();
        assertThat(result3).isFalse();
        assertThat(result4).isFalse();
        assertThat(result5).isTrue();
        assertThat(result6).isFalse();
        assertThat(result7).isFalse();

    }


    @Test
    @DisplayName("입력받은 문자열을 빈 공백으로 split할 경우 마지막 index의 value가 숫자면 True")
    public void isNumberLastListValueTest() {
        String testInput = " 44 + 55 - 2 / 5 ";
        String testInput2 = " 44 + 55 - 2 / ";
        String testInput3 = "";
        InputChecker inputChecker = new InputChecker();

        List<String> testInputList = inputChecker.formulaToStrList(testInput);
        List<String> testInputList2 = inputChecker.formulaToStrList(testInput2);
        List<String> testInputList3 = inputChecker.formulaToStrList(testInput3);
        boolean result = inputChecker.isNumberLastListValue(testInputList);
        boolean result2 = inputChecker.isNumberLastListValue(testInputList2);
        boolean result3 = inputChecker.isNumberLastListValue(testInputList3);

        assertThat(result).isTrue();
        assertThat(result2).isFalse();
        assertThat(result3).isFalse();
    }

    @Test
    @DisplayName("입력받은 문자열이 '숫자 연산자 숫자' 형태가 아닐 경우 예외를 발생시키는 유효성 검사")
    public void validFormulaTest() {
        String testInput = " 44 + 55 - 2 // 5";     // 연산자 2개 들어감
        String testInput2 = " 44 + 55 - 2 / ";      // 마지막이 연산자
        String testInput3 = " 444 55 55 - 2 / 5";   // 숫자 연속
        String testInput4 = " 444 -5- - 2 / 5";     // 띄어쓰기 안함
        String testInput5 = " - 55 - 2 / 5";        // 연산자부터 시작함
        String testInput6 = " 5t5 - 2 / 5";         // 숫자, 연산자 외 다른 글자 입력
        InputChecker inputChecker = new InputChecker();

        List<String> testInputList = inputChecker.formulaToStrList(testInput);
        List<String> testInputList2 = inputChecker.formulaToStrList(testInput2);
        List<String> testInputList3 = inputChecker.formulaToStrList(testInput3);
        List<String> testInputList4 = inputChecker.formulaToStrList(testInput4);
        List<String> testInputList5 = inputChecker.formulaToStrList(testInput5);
        List<String> testInputList6 = inputChecker.formulaToStrList(testInput6);

        assertThatThrownBy(() -> inputChecker.validFormula(testInputList))
                .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> inputChecker.validFormula(testInputList2))
                .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> inputChecker.validFormula(testInputList3))
                .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> inputChecker.validFormula(testInputList4))
                .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> inputChecker.validFormula(testInputList5))
                .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> inputChecker.validFormula(testInputList6))
                .isInstanceOf(RuntimeException.class);
    }
}
