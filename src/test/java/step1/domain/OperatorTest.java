package step1.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OperatorTest {

    @Test
    @DisplayName("생성 테스트")
    void arithmetic_ctor_test() {
        assertThatNoException().isThrownBy(() -> new Operator('/'));
    }

    @ParameterizedTest
    @ValueSource(chars = {
        '\\',
        '=',
        '_'
    })
    @DisplayName("사칙연산자가 아니면 예외가 발생한다.")
    void input_not_arithmeticOperation_throw_exception_test(char input) {
        assertThatThrownBy(() -> new Operator(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("잘못된 연산자입니다.");
    }

    @ParameterizedTest
    @ValueSource(chars = {
        '+',
        '-',
        '*',
        '/'
    })
    @DisplayName("정확한 사칙연산자를 입력하면 예외가 발생하지 않는다.")
    void input_operation_not_throw_exception_test(char input) {
        assertThatNoException().isThrownBy(() -> new Operator(input));
    }
}