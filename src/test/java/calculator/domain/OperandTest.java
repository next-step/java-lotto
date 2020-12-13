package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("피연산자에 대한 테스트")
class OperandTest {
    private static final String MAX_INTEGER_VALUE = "2147483647";
    private static final String MIN_INTEGER_VALUE = "-2147483648";

    @DisplayName("객체 생성시, 기본 값이 0으로 생성한다.")
    @Test
    void createDefaultOperandTest() {
        // When
        Operand operand = new Operand();
        // Then
        assertThat(operand).isEqualTo(new Operand("0"));
    }

    @DisplayName("객체 생성시, 0 또는 양의 정수 문자열 값으로 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "100", MAX_INTEGER_VALUE})
    void createValidOperandTest(String expected) {
        // When
        Operand operand = new Operand(expected);
        // Then
        assertThat(operand.getNumber()).isEqualTo(Integer.parseInt(expected));
    }


    @DisplayName("객체 생성시, 음의 정수 문자열 값을 지정하면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-100", MIN_INTEGER_VALUE})
    void createInvalidIntegerOperandTest(String expected) {
        // When & Then
        assertThatThrownBy(() -> new Operand(expected))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("객체 생성시, 숫자가 아닌 문자열 값을 지정하면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "bb", "ccc"})
    void createInvalidStringOperandTest(String expected) {
        // When & Then
        assertThatThrownBy(() -> new Operand(expected))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
