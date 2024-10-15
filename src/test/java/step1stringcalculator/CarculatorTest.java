package step1stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.Assertions.assertThat;

public class CarculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void init() {
         calculator = new Calculator();

    }



    @ParameterizedTest(name = "나눗셈 정수 반환.반올림연산")
    @CsvSource(value = {"2 + 1 * 3 / 2,4","7 / 2 + 2 - 5,0"})
    public void 입력문자열_사칙연산_테스트(String calculaterString, int resultNumber) {
        System.out.println(calculaterString);
        calculator = new Calculator(calculaterString);
        assertThat(calculator.calculate()).isEqualTo(resultNumber);
    }


}






