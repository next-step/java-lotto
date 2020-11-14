package addcalculator;

import addcalculator.domain.CommaColonStrategy;
import addcalculator.domain.StringAddCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @DisplayName("문자열을 콤마로 분리하여 합을 구하는 테스트")
    @Test
    void splitAndSumByCommaTest(){
        //given
        String delimiter = ",";
        String inputValue = "1,2,3";

        //when
        StringAddCalculator stringAddCalculator = new StringAddCalculator((y) -> y.split(delimiter));
        int sum = stringAddCalculator.calculate(inputValue);

        //then
        assertThat(sum).isEqualTo(6);

    }

    @DisplayName("문자열을 콜론으로 분리하여 합을 구하는 테스트")
    @Test
    void splitAndSumByColonTest(){
        //given
        String delimiter = ":";
        String inputValue = "1:2:3";

        //when
        StringAddCalculator stringAddCalculator = new StringAddCalculator((y) -> y.split(delimiter));
        int sum = stringAddCalculator.calculate(inputValue);

        //then
        assertThat(sum).isEqualTo(6);

    }

    @DisplayName("문자열을 콜론과 콤마로 분리하여 합을 구하는 테스트")
    @Test
    void splitAndSumByColonAndCommaTest(){
        //given
        String inputValue = "1:2,3";

        //when
        StringAddCalculator stringAddCalculator = new StringAddCalculator(new CommaColonStrategy());
        int sum = stringAddCalculator.calculate(inputValue);

        //then
        assertThat(sum).isEqualTo(6);

    }

    @DisplayName("빈문자열 0 반환 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    void inputEmptyStringReturnZeroTest(String inputValue){
        //when
        StringAddCalculator stringAddCalculator = new StringAddCalculator(new CommaColonStrategy());
        int sum = stringAddCalculator.calculate(inputValue);

        //then
        assertThat(sum).isEqualTo(0);
    }

    @DisplayName("문자열을 커스텀구분자로 분리하여 합을 구하는 테스트")
    @Test
    void splitAndSumByCustomCharacterTest(){
        //given
        String inputValue = "//;\n1;2;3";

        //when
        StringAddCalculator stringAddCalculator = new StringAddCalculator(new CommaColonStrategy());
        int sum = stringAddCalculator.calculate(inputValue);

        //then
        assertThat(sum).isEqualTo(6);

    }
}
