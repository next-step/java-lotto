package addcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @DisplayName("문자열을 콤마로 분리하여 합을 구하는 테스트")
    @Test
    void splitByCommaAndSumTest(){
        //given
        String delimiter = ",";
        String inputValue = "1,2,3";

        //when
        String[] splitValue = inputValue.split(delimiter);
        int sum = Arrays.stream(splitValue).mapToInt(i -> Integer.parseInt(i)).sum();

        //then
        assertThat(sum).isEqualTo(6);

    }

    @DisplayName("문자열을 콜론으로 분리하여 합을 구하는 테스트")
    @Test
    void splitByColonAndSumTest(){
        //given
        String delimiter = ":";
        String inputValue = "1:2:3";

        //when
        String[] splitValue = inputValue.split(delimiter);
        int sum = Arrays.stream(splitValue).mapToInt(i -> Integer.parseInt(i)).sum();

        //then
        assertThat(sum).isEqualTo(6);

    }
}
