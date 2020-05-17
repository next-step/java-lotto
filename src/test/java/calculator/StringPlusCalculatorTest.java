package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringPlusCalculatorTest {

    private StringPlusCalculator stringPlusCalculator;

    @BeforeEach
    void setUp() {
        stringPlusCalculator = new StringPlusCalculator();
    }

    @CsvSource(value = {"1:2:3=6", "1,2:3=6", "3,4,7=14"}, delimiter = '=')
    @ParameterizedTest
    @DisplayName("기본 구분자(, :) 를 갖는 문자열을 계산한다.")
    void 문자열_덧셈_기본_구분자_테스트(String input, int expected) {
        int result = stringPlusCalculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

    @ValueSource(strings = {"1:2-3=6", "1!2:3=6", "3*4,7=14"})
    @ParameterizedTest
    @DisplayName("기본 구분자(, :) 이외 구분자를 갖는 문자열은 예외가 발생한다.")
    void 문자열_덧셈_다른_구분자_예외_테스트(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> stringPlusCalculator.calculate(input));
    }
}
