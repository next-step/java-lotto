package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import calculator.domain.StringAddCalculator;
import calculator.domain.InputNumber;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class StringAddCalculatorTest {

    static Stream<String> blankStrings() {
        return Stream.of("", "   ", null);
    }

    @ParameterizedTest
    @MethodSource("blankStrings")
    void empty_and_null_return_zero(String input) throws Exception {
        //Given
        InputNumber inputNumber = new InputNumber(input);
        StringAddCalculator calculator = new StringAddCalculator(inputNumber);

        //When
        int results = calculator.calculate();

        //Then
        assertThat(0).isEqualTo(results);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,3", "4,4"})
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환하는 기능")
    void one_char_input_return_number(String input, int actual) throws Exception {
        //Given
        InputNumber inputNumber = new InputNumber(input);
        StringAddCalculator calculator = new StringAddCalculator(inputNumber);

        //When
        int results = calculator.calculate();

        //Then
        assertThat(actual).isEqualTo(results);
    }

    @ParameterizedTest
    @CsvSource(value = {" ;0", "1,2;3", "1,2,3;6", "1,2:3;6"}, delimiter = ';')
    @DisplayName("숫각 숫자의 합을 반환")
    void addition_numbers(String input, int actual) throws Exception {
        //Given
        InputNumber inputNumber = new InputNumber(input);
        StringAddCalculator calculator = new StringAddCalculator(inputNumber);

        //When
        int results = calculator.calculate();

        //Then
        assertThat(actual).isEqualTo(results);
    }

    @Test
    @DisplayName("숫각 숫자의 합을 반환")
    void custom_calculate() throws Exception {
        //Given
        String input = "//;\n1;2;3";
        InputNumber inputNumber = new InputNumber(input);
        StringAddCalculator calculator = new StringAddCalculator(inputNumber);

        //When
        int results = calculator.calculate();

        //Then
        assertThat(6).isEqualTo(results);
    }

    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
            .isInstanceOf(RuntimeException.class);
    }
}
