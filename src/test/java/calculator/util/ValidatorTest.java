package calculator.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {


    @ParameterizedTest
    @NullSource
    @DisplayName("null 입력값 예외 테스트")
    void nullInputThrowExceptionTest(String input){
        assertThatThrownBy(() -> {
            Validator.validateInput(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값은 null이면 안됩니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {" "})
    @DisplayName("빈공간 입력값 예외 테스트")
    void blankInputThrowExceptionTest(String input){
        assertThatThrownBy(() -> {
            Validator.validateInput(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값은 빈공간이면 안됩니다.");
    }

    @Test
    @DisplayName("올바르지 않은 수식 예외 테스트")
    void unavailableMathExpressionThrowExceptionTest(){
        String[] inputArray = {"2", "+", "3", "-"};
        assertThatThrownBy(() -> {
            Validator.validateExpression(inputArray);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바른 수식이 아닙니다.");
    }
}
