package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SumCalculatorTest {

    private final static SumCalculator SUM_CALCULATOR = SumCalculator.getInstance();

    @ParameterizedTest
    @CsvSource(value = {"3,4,5 = 12", "1,2,3 = 6", "5,3,1 = 9", "10,11,12 = 33"}, delimiter = '=')
    @DisplayName("계산 메서드는 합계를 반환한다")
    public void sumCalculate(String input, int expected) {
        Assertions.assertThat(SUM_CALCULATOR.sumCalculate(input.split(","))).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"b,4,3", "-1,2", "2,c", "-1,2,c,5", "ab,1,2"})
    @DisplayName("음수 혹은 숫자아닌 문자를 인자로 받을 경우 예외를 던진다")
    public void invalidException(String input) {
        Assertions.assertThatThrownBy(() -> {
            SUM_CALCULATOR.sumCalculate(input.split(","));
        }).isInstanceOf(RuntimeException.class);
    }

}
