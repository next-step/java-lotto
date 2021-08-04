package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {

    @Test
    @DisplayName("Input이 empty일 경우 0을 반환한다.")
    void empty() {
        int result = StringAddCalculator.calculate("");
        assertThat(result).isZero();
    }

    @Test
    @DisplayName("input이 null일 경우 0을 반환한다.")
    void nullTest(){
        int result = StringAddCalculator.calculate(null);
        assertThat(result).isZero();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 0})
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    void oneNumber(int input){
        int result = StringAddCalculator.calculate(String.valueOf(input));
        assertThat(result).isEqualTo(input);
    }


}