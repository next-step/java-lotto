package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @DisplayName("덧셈 계산기")
    @ParameterizedTest
    @ValueSource(strings = {"5 + 7"})
    public void add_calculator(String text){

        List<String> list = List.of(text.split(" "));
        assertThat(Operator.calc(list)).isEqualTo(12);
    }

    @DisplayName("뺄셈 계산기")
    @ParameterizedTest
    @ValueSource(strings = {"7 - 3"})
    public void subtract_calculator(String text){

        List<String> list = List.of(text.split(" "));
        assertThat(Operator.calc(list)).isEqualTo(4);
    }

    @DisplayName("곱셈 계산기")
    @ParameterizedTest
    @ValueSource(strings = {"2 * 3"})
    public void multiply_calculator(String text){

        List<String> list = List.of(text.split(" "));
        assertThat(Operator.calc(list)).isEqualTo(6);
    }

    @DisplayName("나눗셈 계산기")
    @ParameterizedTest
    @ValueSource(strings = {"10 / 2"})
    public void divide_calculator(String text){
        List<String> list = List.of(text.split(" "));
        assertThat(Operator.calc(list)).isEqualTo(5);
    }

    @DisplayName("사칙연산 계산기")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    public void test_calculator(String text){

        List<String> list = List.of(text.split(" "));

        int result = Operator.calc(list);

        assertThat(result).isEqualTo(10);
    }

    @DisplayName("사칙연산 계산기")
    @ParameterizedTest
    @ValueSource(strings = {"2 - 2 * 5"})
    public void test2_calculator(String text){

        List<String> list = List.of(text.split(" "));

        int result = Operator.calc(list);

        assertThat(result).isEqualTo(0);
    }


}
