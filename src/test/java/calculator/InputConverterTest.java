package calculator;

import calculator.domain.InputConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

public class InputConverterTest {

    @Test
    @DisplayName("입력받은 문자열 앞뒤 공백 제거 후 빈 공백으로 split 리스트 반환")
    public void formulaToStrListTest() {
        String testInput = " 44 + 55 - 2 / 5 ";

        InputConverter inputConverter = new InputConverter();

        List<String> result = inputConverter.formulaToStrList(testInput);

        assertThat(result.size()).isEqualTo(7);

        assertAll("even index is number",
            () -> assertEquals(result.get(0), "44"),
            () -> assertEquals(result.get(2), "55"),
            () -> assertEquals(result.get(4), "2"),
            () -> assertEquals(result.get(6), "5")
        );

        assertAll("odd index is operator",
            () -> assertEquals(result.get(1), "+"),
            () -> assertEquals(result.get(3), "-"),
            () -> assertEquals(result.get(5), "/")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    @DisplayName("입력받은 문자열이 빈 공백일 때 IllegalArgumentException 예외발생")
    public void formulaToStrListTest2(String test) {
        InputConverter inputConverter = new InputConverter();

        assertThatThrownBy(() -> inputConverter.formulaToStrList(test))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"5 - 5 -", "5 - 5 -5", "5 - 5 tt"})
    @DisplayName("입력받은 문자열의 마지막이 숫자가 아닐 경우 IllegalArgumentException 예외발생")
    public void formulaToStrListTest3(String test) {
        InputConverter inputConverter = new InputConverter();

        assertThatThrownBy(() -> inputConverter.formulaToStrList(test))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
