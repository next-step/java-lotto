package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setup(){
        calculator = new Calculator(new StringTokenParser());
    }

    @DisplayName("빈문자열의 계산 결과는 0이다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "   ", "  \t\n"})
    @NullAndEmptySource
    void return_0_when_empty_string(String input) {
        long result = calculator.calculate(input);

        assertThat(result).isEqualTo(0);
    }


    @DisplayName("하나의 정수값의 계산 결과는 핻아 정수값이다.")
    @ParameterizedTest
    @CsvSource(
        delimiter= ',',
        value = {"1,1","2,2"}
    )
    void return_single_val_when_input_single_val(String input, long expect){
        long result = calculator.calculate(input);

        assertThat(result).isEqualTo(expect);
    }

    @DisplayName("','으로 정수를 구분할수 있다.")
    @ParameterizedTest
    @CsvSource(
        delimiterString= "==",
        value = {"1,2==3","1,2,3==6"}
    )
    void given_dot_when_calculate_then_split_with_dot(String input, long expect){
        long result = calculator.calculate(input);

        assertThat(result).isEqualTo(expect);
    }

    @DisplayName("';'으로 정수를 구분할수 있다.")
    @ParameterizedTest
    @CsvSource(
        delimiterString= "==",
        value = {"1:2==3","1:2:3==6"}
    )
    void given_colon_when_calculate_then_split_with_colon(String input, long expect){
        long result = calculator.calculate(input);

        assertThat(result).isEqualTo(expect);
    }

    @DisplayName("',', ';' 두개로 정수를 구분할수 있다.")
    @ParameterizedTest
    @CsvSource(
        delimiterString= "==",
        value = {"1:2,3==6","1,2:3==6"}
    )
    void given_colon_and_dot_when_calculate_then_split_with_colon_and_dot(String input, long expect){
        long result = calculator.calculate(input);

        assertThat(result).isEqualTo(expect);
    }

    @DisplayName("숫자 이외의 값 전달시 예외 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"z","1+2"})
    void given_invalid_format_when_calculate_then_throw_exception(String input){
        assertThatThrownBy(() -> calculator.calculate(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음수를 전달하는 경우 예외 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1","-1,-2","-1:2"})
    void given_negative_when_calculate_then_throw_exception(String input){
        assertThatThrownBy(() -> calculator.calculate(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("커스텀 구분자를 '//{구분자}\\n{정수}'형식으로 사용할수있다.")
    @ParameterizedTest
    @MethodSource("customSplitter")
    void given_custom_splitter_when_calculate_then_add_result(String input, long expect){
        long result = calculator.calculate(input);
        
        assertThat(result).isEqualTo(expect);
    }

    static Stream<Arguments> customSplitter() {
        return Stream.of(
            arguments("//;\n1;2;3", 6),
            arguments("///\n1/2/3", 6),
            arguments("//;\n", 0)
        );
    }
}
