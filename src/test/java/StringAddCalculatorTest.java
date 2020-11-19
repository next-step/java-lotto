import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    private StringAddCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringAddCalculator();
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0) ")
    void empty_or_null_test(String input) {
        assertThat(calculator.add(input)).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3"}, delimiter = ':')
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)")
    void single_number_test(String input, int result) {
        assertThat(calculator.add(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3", "2,5:7", "3,6:9"}, delimiter = ':')
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)")
    void split_by_comma_test(String input, int result) {
        assertThat(calculator.add(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3=6", "2,5:7=14", "3,6:9=18"}, delimiter = '=')
    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)")
    void split_by_comma_or_colon_test(String input, int result) {
        assertThat(calculator.add(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"//;\\n1;2;3=6", "//#\\n1#2#3=6", "//&\\n1&2&6=9"}, delimiter = '=')
    @DisplayName("“//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)")
    void custom_delimiter_test(String input, int result) {
        assertThat(calculator.add(input)).isEqualTo(result);
    }
}
