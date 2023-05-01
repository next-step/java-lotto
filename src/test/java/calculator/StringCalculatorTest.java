package calculator;

import calculator.StringCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {
    StringCalculator stringCalculator;
    @BeforeEach
    void createObject(){
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("빈값입력 테스트")
    void checkEmptyStringTest() {
        Assertions.assertThatThrownBy(() -> {
                    stringCalculator.calculation("");
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("연산식을 입력해 주시기 바랍니다.");
    }

    @Test
    @DisplayName("null 입력 테스트")
    void checkNullStringTest() {
        Assertions.assertThatThrownBy(() -> {
                    stringCalculator.calculation(null);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("연산식을 입력해 주시기 바랍니다.");
    }

    @Test
    @DisplayName("연산식 숫자 예외처리 테스트")
    void checkNumberValidation() {
        Assertions.assertThatThrownBy(() -> {
                    stringCalculator.calculation("a * 3");
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자자리에 다른 문자가 입력되었습니다.");
    }

    @Test
    @DisplayName("연산식 연산자 예외처리 테스트")
    void checkOperatorValidation() {
        Assertions.assertThatThrownBy(() -> {
                    stringCalculator.calculation("3 % 3");
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("연산자 자리에 다른 문자가 입력되었습니다.");
    }

    @Test
    @DisplayName("연산식 테스트")
    void operatorTest() {
        assertThat(stringCalculator.calculation("2 + 3 * 4 / 2")).isEqualTo(10);
    }
}
