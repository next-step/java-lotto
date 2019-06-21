package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {

    @DisplayName("default 구분자를 사용하여 문자열 합계 반환")
    @ParameterizedTest
    @CsvSource({
            "'1,2,3',   6",
            "'1,2:4',   7",
    })
    void sumByDefaultExpression(String inputOfString, int expectedResult) {
        int result = StringCalculator.calculator(inputOfString);
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("입력값이 null 또는 empty 일 경우 0 반환")
    @ParameterizedTest
    @NullAndEmptySource
    void sumByInputIsEmpty(String inputOfEmpty) {
        assertThat(StringCalculator.calculator(inputOfEmpty)).isEqualTo(0);
    }

    @DisplayName("커스텀 구분자를 사용할 때 성공하는 테스트")
    @ParameterizedTest
    @CsvSource({
            "'//;\n1;2;3',  6",
            "'//a\n1a2a3',  6"
    })
    void sumByInputWithCustomDelimiter(String inputOfEmpty, int expectedResult) {
        int result = StringCalculator.calculator(inputOfEmpty);
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("음수 또는 잘못된 문자열 입력 시 에러")
    @ParameterizedTest
    @ValueSource(strings = {
            "-1,2,3",
            "a,b,c",
            "//,b,c",
            "\n,b,c",
    })
    public void sumByWrongInputThenFail(String wrongInput) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringCalculator.calculator(wrongInput));
    }
}

