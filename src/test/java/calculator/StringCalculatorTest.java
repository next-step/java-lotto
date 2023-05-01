package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringCalculatorTest {
    @DisplayName("유효하지 않은 값이 입력된 경우 IllegalArgumentException 예외가 발생하는지 확인")
    @ParameterizedTest(name = "textInput : {0}")
    @NullAndEmptySource
    void pass_null_or_blank_value_illegal_argument_exception(String textInput) {
        assertThatThrownBy(() -> StringCalculator.split(textInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 문자열이 null 또는 공백 일 수 없습니다.");
    }

}
