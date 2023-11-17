package calculator.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import calculator.view.InputView;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

    @DisplayName("긴 문자열 수식에 대한 계산 - 성공")
    @CsvSource(value = {"2 + 3 * 4 = 20", "10 / 2 - 3 = 2"}, delimiter = '=')
    @ParameterizedTest
    void calculateWithLongString(String origin, int expected) {
        Variable result = Calculator.of(origin).calculate();
        Assertions.assertThat(result.value()).isEqualTo(expected);
    }

    @DisplayName("빈 문자열은 예외를 반환")
    @NullAndEmptySource
    @ParameterizedTest
    void throwIllegalArgumentExceptionWhenNullOrEmptyString(String emptyString) {
        assertThatThrownBy(() -> Calculator.of(emptyString).calculate()).isInstanceOf(
            IllegalArgumentException.class);
    }


}
