package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator = Calculator.of();
    }

    @Test
    @DisplayName("공백을 기준으로 문자열을 자른다.")
    void test1() {
        String expression = "2 + 3 * 4 / 2";

        List<String> result = calculator.splitByBlank(expression);

        assertThat(result.get(0)).isEqualTo("2");
        assertThat(result.get(1)).isEqualTo("+");
    }

    @Test
    @DisplayName("정규식에 맞는 연산식이 들어오면 true 반환")
    void test122(){
        String expression = "2 + 3 - 1";
        boolean result = calculator.isValidMathExpression(expression);
        assertThat(result).isTrue();
    }


    @Test
    @DisplayName("입력 값이 null 이거나 공백인 경우 예외처리")
    void test6(){
        String expression = " ";
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.isValidMathExpression(expression);
        }).withMessage("please input valid value");
    }

    @Test
    @DisplayName("사칙연산이 아닌 경우 예외처리")
    void test7(){
        String expression = "2 & 8";
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.isValidMathExpression(expression);
        }).withMessage("please input valid value");
    }

    @Test
    @DisplayName("덧셈")
    void test2(){
        int result = calculator.calculate(5,"+",2);
        assertThat(result).isEqualTo(7);
    }

    @Test
    @DisplayName("뺄셈")
    void test3(){
        int result = calculator.calculate(5,"-",2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("곱셈")
    void test4(){
        int result = calculator.calculate(5,"*",2);
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("나눗셈")
    void test5(){
        int result = calculator.calculate(5,"/",2);
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("사칙연산")
    void add(){
        String rawExpression = "2 + 3 * 4 / 2";
        List<String> expression = calculator.splitByBlank(rawExpression);

        int result = calculator.runCalculator(expression);
        assertThat(result).isEqualTo(10);
    }
}
