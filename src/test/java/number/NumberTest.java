package number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class NumberTest {

    @DisplayName("생성 실패: 음수값 문자의 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = "-1")
    void createFailureByNegativeNumber(final String number) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> Number.of(number));
    }

    @DisplayName("생성 실패: 숫자 이외의 값, null, empty 예외 발생")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = "숫자 이외의 값")
    void createFailureByNotNumberFormat(final String number) {
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> Number.of(number));
    }
}
