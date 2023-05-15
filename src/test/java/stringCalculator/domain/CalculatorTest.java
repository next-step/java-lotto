package stringCalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

    static Stream<Arguments> arithmetic(){
        return Stream.of(
                Arguments.arguments(new Calculator("3 + 3"), 6),
                Arguments.arguments(new Calculator("3 - 3"), 0),
                Arguments.arguments(new Calculator("3 * 3"), 9),
                Arguments.arguments(new Calculator("3 / 3"), 1),
                Arguments.arguments(new Calculator("1 + 3 - 1 * 4 / 2"), 6)
        );
    }

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

    @ParameterizedTest(name = "연산 : {0}, 결과 : {1}")
    @MethodSource("arithmetic")
    @DisplayName("사칙연산 테스트")
    public void test6(Calculator cal, int result){
        assertThat(cal.calculateResult()).isEqualTo(result);
    }

}
