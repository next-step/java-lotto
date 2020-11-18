package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    StringCalculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new StringCalculator();
    }

    @ParameterizedTest
    @DisplayName(", 또는 : 을 구분자로 가지는 문자열을 전달하면 숫자의 합을 계산해준다")
    @CsvSource(value = {"1=1","1,2=3","1,2,3=6", "1,2:3=6"}, delimiterString = "=")
    void sum(String expression, int expected){
        assertThat(calculator.sum(expression)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("Null 또는 빈물자열을 입력하면 0 을 return 한다")
    @NullAndEmptySource
    void sumNullAndEmpty(String expression){
        assertThat(calculator.sum(expression)).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\\n1;2;3", "//@\\n1@2@3", "//#\\n1#2#3"})
    void customDelimiter(String expression){
        assertThat(calculator.sum(expression)).isEqualTo(6);
    }

    @ParameterizedTest
    @DisplayName("수식에 숫자 이외의 값 또는 음수가 포함되면 RuntimeException 이 발생한다")
    @ValueSource(strings = {"1,a,3", "3,-1,-5"})
    void invalidExpression(String expression){
        assertThatThrownBy(() -> calculator.sum(expression) ).isInstanceOf(RuntimeException.class);
    }

}
