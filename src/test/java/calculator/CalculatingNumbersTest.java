package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CalculatingNumbersTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Null 또는 빈 문자")
    public void create_nullOrEmpty(String param) {
        // given when then
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(
                        () -> new CalculatingNumbers(param)
                ).withMessageMatching("수식을 입력해 주세요.");
    }
}