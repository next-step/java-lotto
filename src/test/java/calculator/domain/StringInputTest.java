package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringInputTest {

    @DisplayName("입력 연산식이 빈 값 또는 null 값인 경우 익셉션 처리한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void error_null_empty(final String input) {

        assertThatThrownBy(() -> new StringInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값이 null 또는 빈 공백 입니다.");
    }

    @DisplayName("문자열로 입력받은 계산식을 리스트 형식으로 변환한다.")
    @Test
    void input_string() {

        assertThat(new StringInput("3 * 2").split()).contains("3", "*", "2");
    }
}
