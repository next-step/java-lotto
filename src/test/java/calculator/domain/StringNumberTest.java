package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static calculator.domain.Operator.DIVIDE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringNumberTest {

    @DisplayName("StringNumber 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "1"})
    void createStringNumberTest(String number) {
        assertThat(new StringNumber(number))
                .isEqualTo(new StringNumber(number));
    }

    @DisplayName("StringNumber 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "1"})
    void createStringNumberTestFail(String number) {
        assertThat(new StringNumber(number))
                .isEqualTo(new StringNumber(number));
    }

    @DisplayName("StringNumber간의 계산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"10:2:+:12", "10:2:-:8", "10:2:*:20", "10:2:/:5", "10:3:/:3"}, delimiter = ':')
    void calculateTest(String number1, String number2, String symbol, String result) {
        Operator operator = Operator.findOperatorFromSymbol(symbol);
        assertThat(new StringNumber(number1).calculate(operator, new StringNumber(number2)))
                .isEqualTo(new StringNumber(result));
    }

    @DisplayName("StringNumber간의 계산 테스트 - 0으로 나눈 경우")
    @Test
    void calculateTestFail() {
        assertThatThrownBy(() ->new StringNumber("1").calculate(DIVIDE, new StringNumber("0")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("출력할 때 사용하기 위한 toInt 기능 테스트")
    @ParameterizedTest
    @CsvSource(value = {"-1:-1", "0:0", "1:1"}, delimiter = ':')
    void toIntTest(String inputNumber, int resultNumber) {
        assertThat(new StringNumber(inputNumber).toInt()).isEqualTo(resultNumber);
    }
}