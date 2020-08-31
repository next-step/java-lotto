package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringPlusCalculatorTest {

    private StringPlusCalculator calculator = new StringPlusCalculator();

    @DisplayName("null 또는 빈문자 계산 테스트")
    @Test
    void nullOrEmptyTest(){
        String numbers = "";
        assertThat(calculator.calculate(numbers)).isEqualTo(0);

        numbers = null;
        assertThat(calculator.calculate(numbers)).isEqualTo(0);
    }

    @DisplayName("숫자 하나 계산 테스트")
    @Test
    void singleFactorTest(){
        String numbers = "1";
        assertThat(calculator.calculate(numbers)).isEqualTo(1);
    }

    @DisplayName("쉼표 구분자 계산 테스트")
    @Test
    void commaSeparatorTest(){
        String numbers = "1,2";
        assertThat(calculator.calculate(numbers)).isEqualTo(3);
    }

    @DisplayName("콤마, 세미콜론 계산 테스트")
    @Test
    void commaAndSemicolonTest(){
        String numbers = "1,2:3";
        assertThat(calculator.calculate(numbers)).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자 계산 테스트 ")
    @Test
    void calculateTest(){
        String numbers = "//;\n1;2;3";
        assertThat(calculator.calculate(numbers)).isEqualTo(6);
    }

    @DisplayName("음수 값 전달하는 경우 RuntimeException")
    @Test
    void minusExceptionTest(){
        String numbers = "-1,2,3";
        assertThatThrownBy(()->{
            calculator.calculate(numbers);
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("숫자 외 값 전달하는 경우 RuntimeException")
    @Test
    void notNumberFactorExceptionTest(){
        String numbers = "#,2,3";
        assertThatThrownBy(()->{
            calculator.calculate(numbers);
        }).isInstanceOf(RuntimeException.class);
    }

}
