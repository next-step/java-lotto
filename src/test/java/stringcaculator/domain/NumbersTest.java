package stringcaculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {
    @Test
    @DisplayName("숫자들이 정상적으로 반환되는지 확인합니다.")
    void numbers() {
        String number1 = "1";
        String number2 = "2";
        String number3 = "3";
        String[] numberArray = {number1, number2, number3};
        Numbers numbers = new Numbers(numberArray);
        assertThat(numbers.numbers()).isEqualTo(Arrays.asList(new Number(new StringToIntegerValue(number1)), new Number(new StringToIntegerValue(number2)), new Number(new StringToIntegerValue(number3))));
    }
}