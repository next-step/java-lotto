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
    @DisplayName("입력받은 문자열 앞뒤 공백 제거 후 빈 공백으로 split 리스트 반환")
    public void formulaToStrListTest() {
        String testInput = " 44 + 55 - 2 / 5 ";

        InputChecker inputChecker = new InputChecker();

        List<String> result = inputChecker.formulaToStrList(testInput);

        assertThat(result.size()).isEqualTo(7);

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
    @DisplayName("입력받은 문자열이 빈 공백일 때 IllegalArgumentException 예외발생")
    public void formulaToStrListTest2(String test) {
        InputChecker inputChecker = new InputChecker();

        assertThatThrownBy(() -> inputChecker.formulaToStrList(test))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"5 - 5 -", "5 - 5 -5", "5 - 5 tt"})
    @DisplayName("입력받은 문자열의 마지막이 숫자가 아닐 경우 IllegalArgumentException 예외발생")
    public void formulaToStrListTest3(String test) {
        InputChecker inputChecker = new InputChecker();

        assertThatThrownBy(() -> inputChecker.formulaToStrList(test))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
