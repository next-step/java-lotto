package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class StringCalculatorTest {

    StringCalculator calculator = new StringCalculator();

    @DisplayName("입력이 null이거나 빈 문자열인 경우 throw IllegalArgumentException")
    @ParameterizedTest
    @NullAndEmptySource
    void test1(String value){
        Assertions.assertThatThrownBy(() -> calculator.calculate(value)).isInstanceOf(IllegalArgumentException.class);
    }

}