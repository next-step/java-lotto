package stringpluscalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositiveNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"r", "ㅋ", "ㅎ", "ㅇ", "-1", "-4"})
    @DisplayName("input 문자열을 양의 정수로 변환 실패 테스트")
    void convertNumberTest(String input) {
        assertThatThrownBy(
                () -> new PositiveNumber(input)
        ).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -11, -14})
    @DisplayName("input 숫자의 양의 정수 validation 실패 테스트")
    void convertNumberTest(int input) {
        assertThatThrownBy(
                () -> new PositiveNumber(input)
        ).isInstanceOf(RuntimeException.class);
    }
}
