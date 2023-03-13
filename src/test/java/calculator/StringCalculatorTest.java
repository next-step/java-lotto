package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringCalculatorTest {

    @DisplayName("계산할 문자열을 가질 수 있다.")
    @Test
    public void save() {
        //given
        String calculatorSumString = "1:2:3";

        // when
        StringCalculator stringCaclulator = new StringCalculator(calculatorSumString);

        // then
        assertThat(stringCaclulator.getCalculatorSumString()).isEqualTo(calculatorSumString);
    }

    @DisplayName("구분자로 나눠 계산할 숫자 리스트로 리턴해준다.")
    @Test
    public void split() {
        //given
        String calculatorSumString = "1:2:3";

        // when
        StringCalculator stringCaclulator = new StringCalculator(calculatorSumString);
        List<Integer> list = stringCaclulator.getSplitCalculatorNumbers();

        // then
        assertThat(list)
                .hasSize(3)
                .containsExactlyInAnyOrder(1, 2, 3);
    }

    @DisplayName("커스텀 구분자를 가질 수 있다.")
    @Test
    public void saveCustom() {
        //given
        String customDelimeter = "//;\n";

        // when
        StringCalculator stringCaclulator = new StringCalculator(customDelimeter);
        String delimeter = stringCaclulator.initDelimeter(customDelimeter);

        // then
        assertThat(delimeter).isEqualTo(";");
    }

    @DisplayName("구분자로 나눠 계산할 숫자 리스트로 리턴해준다.")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "1:2,3"})
    public void split2(final String testString) {
        //given
        String calculatorSumString = testString;

        // when
        StringCalculator stringCaclulator = new StringCalculator(calculatorSumString);
        List<Integer> list = stringCaclulator.getSplitCalculatorNumbers();

        // then
        assertThat(list)
                .hasSize(3)
                .containsExactlyInAnyOrder(1, 2, 3);
    }

    @DisplayName("정의되지않은 구분자가 들어오면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1;2;3", "1:2,-3"})
    public void errorThrow(String testValue) {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    // when
                    StringCalculator stringCaclulator = new StringCalculator(testValue);
                }).withMessageContaining("정의되지않은 값이 들어감");
    }

    @DisplayName("덧셈이 가능하다. ")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "1:2,3", "6"})
    void sumTest(String value) {

        // when
        StringCalculator stringCaclulator = new StringCalculator(value);
        Integer sumResult = stringCaclulator.getSum();

        // then
        assertThat(sumResult).isEqualTo(6);
    }

    @DisplayName("null 이면 0을 반환한다.")
    @Test
    void sumTest() {
        // when
        StringCalculator stringCaclulator = new StringCalculator(null);
        Integer sumResult = stringCaclulator.getSum();

        // then
        assertThat(sumResult).isEqualTo(0);
    }


}

