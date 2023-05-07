package stringCalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import stringCalculator.domain.Calculator;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class CalculatorTest {

    @Test
    @DisplayName("입력 공식 분리")
    public void test1(){
        Calculator calculator = new Calculator();
        String[] result = {"1","+","2","*","3"};
        for (int i = 0; i <result.length ; i++) {
            assertThat( calculator.stringEmptySeparation("1 + 2 * 3")[i]).isEqualTo(result[i]);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"+","-","*","/"})
    @DisplayName("산술연산자 구분 true")
    public void test2(String strings){
        Calculator calculator = new Calculator();
        assertThat(calculator.checkOperator(strings)).isTrue();
    }
    @ParameterizedTest
    @ValueSource(strings = {"1","2","3","4"})
    @DisplayName("산술연산자 구분 flase")
    public void test3(String strings){
        Calculator calculator = new Calculator();
        assertThat(calculator.checkOperator(strings)).isFalse();
    }

    @Test
    @DisplayName("연산자만 추출")
    public void test4(){
        Calculator calculator = new Calculator("1 + 2 * 3");
        assertThat(calculator.operators.toString()).isEqualTo("[+, *]");
    }

    @Test
    @DisplayName("숫자만 추출")
    public void test5(){
        Calculator calculator = new Calculator("1 + 2 * 3");
        assertThat(calculator.numbers.toString()).isEqualTo("[1, 2, 3]");
    }

    @Test
    @DisplayName("더하기")
    public void test6(){
        Calculator calculator = new Calculator("3 + 3");
        assertThat(calculator.calculateResult()).isEqualTo(3);
    }

    @Test
    @DisplayName("빼기")
    public void test7(){
        Calculator calculator = new Calculator("3 - 3");
        assertThat(calculator.calculateResult()).isEqualTo(0);
    }

    @Test
    @DisplayName("곱하기")
    public void test8(){
        Calculator calculator = new Calculator("3 * 3");
        assertThat(calculator.calculateResult()).isEqualTo(9);
    }

    @Test
    @DisplayName("나누기")
    public void test9(){
        Calculator calculator = new Calculator("3 / 3");
        assertThat(calculator.calculateResult()).isEqualTo(1);
    }

    @Test
    @DisplayName("사칙연산 계산")
    public void test10(){
        Calculator calculator = new Calculator("1 + 3 - 1 * 4 / 2");
        assertThat(calculator.calculateResult()).isEqualTo(6);
    }
}
