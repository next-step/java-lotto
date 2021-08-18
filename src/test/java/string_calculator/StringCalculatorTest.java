package string_calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    private final StringCalculator stringCalculator = StringCalculator.getCalculator();

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력값이 null이나 빈값일때 테스트")
    void inputTest(String input){
        assertThat(stringCalculator.empty(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource("-2,-1")
    @DisplayName("입력값 예외 테스트")
    void validate(int operand){
        assertThatThrownBy(()->{
            stringCalculator.validate(operand);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "//;\n1;2;3"})
    @DisplayName("문자열 덧셈 테스트")
    void calculateTest(String expression){
        assertThat(stringCalculator.calculate(expression)).isEqualTo(6);
    }

    @Test
    @DisplayName("문자열 덧셈-값 없는 경우- 테스트")
    void calculateTest(){
        String expression = "";
        assertThat(stringCalculator.calculate(expression)).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"'1',1", "'2',2"})
    @DisplayName("문자열 덧셈-값 없는 경우-숫자 하나인 경우- 테스트")
    void calculateTest2(String operand, int result){
        assertThat(stringCalculator.calculate(operand)).isEqualTo(result);
    }
}
