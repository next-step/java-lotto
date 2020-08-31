package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringPlusCalculatorTest {

    private StringPlusCalculator calculator = new StringPlusCalculator();

    @DisplayName("사용자 정의 구분자 사용되었는지 여부 테스트")
    @Test
    void isCustomSeparatorUsedTest(){
        String numbers = "//;\n1;2;3";
        assertThat(calculator.isCustomSeparatorUsed(numbers)).isTrue();
    }

    @DisplayName("사용자 정의 구분자 추출 테스트")
    @Test
    void parseCustomSeparatorTest(){
        String numbers = "//;\n1;2;3";
        String separator = calculator.parseCustomSeparator(numbers);

        assertThat(separator).isEqualTo(";");
    }

    @DisplayName("사용자 정의 구분자 사용시 factor(인자) 추출 테스트")
    @Test
    void customSeparatorNumbersParsingTest(){
        String numbers = "//;\n1;2;3";
        String[] expectedFactors = {"1", "2", "3"};

        assertThat(calculator.parseNumbers(numbers)).isEqualTo(expectedFactors);
    }

    @DisplayName("null 또는 빈문자 계산 테스트")
    @Test
    void nullOrEmptyTest(){
        String factor = "";
        assertThat(calculator.calculate(factor)).isEqualTo(0);

        factor = null;
        assertThat(calculator.calculate(factor)).isEqualTo(0);
    }

    @DisplayName("숫자 하나 계산 테스트")
    @Test
    void singleFactorTest(){
        String factors = "1";
        assertThat(calculator.calculate(factors)).isEqualTo(1);
    }

    @DisplayName("쉼표 구분자 계산 테스트")
    @Test
    void commaSeparatorTest(){
        String factors = "1,2";
        assertThat(calculator.calculate(factors)).isEqualTo(3);
    }

    @DisplayName("콤마, 세미콜론 계산 테스트")
    @Test
    void commaAndSemicolonTest(){
        String factors = "1,2:3";
        assertThat(calculator.calculate(factors)).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자 계산 테스트 ")
    @Test
    void calculateTest(){
        String factors = "//;\n1;2;3";
        assertThat(calculator.calculate(factors)).isEqualTo(6);
    }

    @DisplayName("음수 값 전달하는 경우 RuntimeException")
    @Test
    void minusExceptionTest(){
        String factors = "-1,2,3";
        assertThatThrownBy(()->{
            calculator.calculate(factors);
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("숫자 외 값 전달하는 경우 RuntimeException")
    @Test
    void notNumberFactorExceptionTest(){
        String factors = "#,2,3";
        assertThatThrownBy(()->{
            calculator.calculate(factors);
        }).isInstanceOf(RuntimeException.class);
    }

}
