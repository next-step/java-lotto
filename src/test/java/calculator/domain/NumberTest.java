package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    @DisplayName("입력값이 정수 타입일경우 참을 반환")
    @ParameterizedTest
    @ValueSource(strings = {"123", "0", "-1"})
    void 정수_타입이면_참을_반환(String str) {
        Number number = new Number(str);

        assertThat(number.isInteger(str)).isTrue();
    }
}
