package Calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {


    @Test
    void splitWithMatcher_Default() {
        //given
        String input = "1,2:3";
        String[] predict = {"1", "2", "3"};

        //when
        String[] result = StringAddCalculator.splitWithMatcher(input);

        //then
        assertThat(result).isEqualTo(predict);
    }

    @Test
    void splitWithMatcher_Match() {
        //given
        String input = "//;\n1;2;3";
        String[] predict = {"1", "2", "3"};

        //when
        String[] result = StringAddCalculator.splitWithMatcher(input);

        //then
        assertThat(result).isEqualTo(predict);
    }

    @Test
    void intArrToOperandTest() {
        //given
        int[] arr = {1, 2, 3};
        List<Operand> operandList = new ArrayList<>();
        Arrays.stream(arr).forEach(Integer -> {
            operandList.add(new Operand(Integer));
        });
        Operands predict = new Operands(operandList);

        //when
        Operands result = StringAddCalculator.intArrToOperands(arr);


        //then
        assertThat(result).isEqualTo(predict);
    }

    @ParameterizedTest
    @CsvSource(value = {"1=1", "1,2=3", "1,2:3=6"}, delimiter = '=')
    void calculateTest(String input, int result) {
        assertThat(StringAddCalculator.calculate(input)).isEqualTo(result);
    }

    @Test
    void calculate_CustomDel() {
        //given
        String customStr = "//;\n1;2;3";
        int predict = 6;

        //when, then
        assertThat(StringAddCalculator.calculate(customStr)).isEqualTo(predict);
    }

    @Test
    void calculate_fail() {
        assertThatThrownBy(() -> {
            StringAddCalculator.calculate("-1:3:2");
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
