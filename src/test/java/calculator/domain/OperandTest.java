package calculator.domain;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

class OperandTest {

    @DisplayName("음수는 피연산자로 사용할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1, -2, -100"})
    void createFailWithNegativeValue(String value) {
        // when
        ThrowableAssert.ThrowingCallable callable = () -> Operand.from(value);

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(callable)
                .withMessageMatching("양의 정수만 피연산자로 사용할 수 있습니다.");
    }

    @DisplayName("null 또는 빈문자열을 피연산자로 사용할 수 없다.")
    @ParameterizedTest
    @NullAndEmptySource
    void createFailWithNullOrEmptyValue(String value) {
        // when
        ThrowableAssert.ThrowingCallable callable = () -> Operand.from(value);

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(callable)
                .withMessageMatching("null 또는 빈문자열을 피연산자로 사용할 수 없습니다.");
    }

    @DisplayName("양의 정수를 입력받아 피연산자를 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "100"})
    void create(String value) {
        // when
        Operand operand = Operand.from(value);

        // then
        assertAll(
                () -> assertThat(operand.getValue()).isEqualTo(Integer.parseInt(value)),
                () -> assertThat(operand).isEqualTo(Operand.from(value))
        );
    }
}
