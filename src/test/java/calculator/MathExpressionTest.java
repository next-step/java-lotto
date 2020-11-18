package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MathExpressionTest {

    @ParameterizedTest
    @DisplayName("수식에 0,양수 이외에 값을 사용하면 exception 이 발생한다")
    @ValueSource(strings = {"1,-1,3", "a,1,2", "@,1,3"})
    void validate(String expression){
        assertThatThrownBy(() -> new MathExpression(expression,","))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @DisplayName("수식의 합을 계산 할 수 있다")
    @CsvSource(value = {"1,2,3=6", "1,0,1=2", "3,5,7=15"}, delimiterString = "=")
    void sum(String expression, int expected){
        assertThat(new MathExpression(expression, ",").execute(Integer::sum))
                .isEqualTo(expected);
    }

}