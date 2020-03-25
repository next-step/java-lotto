import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {
    @DisplayName("null 또는 공백이 입력되면 true를 리턴한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void isNullOrEmptyTest(String input) {
        assertThat(StringAddCalculator.isNullOrEmpty(input)).isTrue();
    }

    @DisplayName("기본 구분자로 구분된 문자열을 입력하면, 숫자로 간주되는 문자열의 갯수를 가진 콜렉션이 리턴된다.")
    @ParameterizedTest
    @CsvSource(value = {"2,4,5=3", "23:4=2", "2,24,20:1,5=5"}, delimiter = '=')
    void extractStringNumberTest(String input, int expected) {
        assertThat(StringAddCalculator.splitByDefault(input).size()).isEqualTo(expected);
    }
}
