package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class OperatorEnumTest {
    @DisplayName("2개의 값을 더한다.")
    @ParameterizedTest(name = "2개의 값을 더한다.")
    @CsvSource(value = {"4:2:+:6", "3:1:+:4", "7:2:+:9"}, delimiter = ':')
    void add(int firstInput, int secondInput, String operator, int excepted) {
        assertThat(OperatorEnum.calculate(operator, firstInput, secondInput)).isEqualTo(excepted);
    }

    @DisplayName("두개의 값을 뺀다.")
    @ParameterizedTest(name = "두개의 값을 뺀다.")
    @CsvSource(value = {"4:2:-:2", "3:1:-:2", "7:2:-:5"}, delimiter = ':')
    void minus(int firstInput, int secondInput, String operator, int excepted) {
        assertThat(OperatorEnum.calculate(operator, firstInput, secondInput)).isEqualTo(excepted);
    }

    @DisplayName("두개의 값을 곱한다.")
    @ParameterizedTest(name = "두개의 값을 곱한다.")
    @CsvSource(value = {"4:2:*:8", "3:1:*:3", "7:2:*:14"}, delimiter = ':')
    void multiply(int firstInput, int secondInput, String operator, int excepted) {
        assertThat(OperatorEnum.calculate(operator, firstInput, secondInput)).isEqualTo(excepted);
    }

    @DisplayName("두개의 값을 나눈다")
    @ParameterizedTest
    @CsvSource(value = {"4:2:/:2", "3:1:/:3", "8:2:/:4"}, delimiter = ':')
    void divide(int firstInput, int secondInput, String operator, int excepted) {
        assertThat(OperatorEnum.calculate(operator, firstInput, secondInput)).isEqualTo(excepted);
    }

    @DisplayName("연산자에 해당하는지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"+:true", "-:true", "*:true", "/:true", "&:false", "4:false"}, delimiter = ':')
    void 연산자_확인(String operator, boolean expectedBoolean) {
        assertThat(OperatorEnum.contains(operator)).isEqualTo(expectedBoolean);
    }
}