package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringNumberTest {

    @DisplayName("StringNumber 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "11", "111"})
    void createTest(String input) {
        StringNumber stringNumber = new StringNumber(input);
        Assertions.assertThat(stringNumber).isEqualTo(new StringNumber(input));
    }

    @DisplayName("StringNumber 생성 테스트 - 실패 케이스")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0.1", "일", "이", "#"})
    void createTestFail(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new StringNumber(input));
    }

    @DisplayName("StringNumber 계산 기능 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:1:+:2", "4:2:-:2", "11:11:*:121", "121:11:/:11"}, delimiter = ':')
    void calculateTest(String number1, String number2, String operator, String result) {
        StringNumber stringNumber1 = new StringNumber(number1);
        StringNumber stringNumber2 = new StringNumber(number2);
        StringOperator operatorString = new StringOperator(operator);
        assertThat(stringNumber1.calculate(operatorString, stringNumber2)).isEqualTo(new StringNumber(result));
    }
}
