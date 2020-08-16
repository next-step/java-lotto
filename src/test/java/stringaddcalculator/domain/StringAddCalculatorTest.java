package stringaddcalculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @DisplayName("콜론(:) 및 콤마(,)로 구분된 숫자의 합")
    @CsvSource(value = {"3,4/7", "1:2/3", "1,2:3/6", "1:3,6/10"}, delimiter = '/')
    void splitAndSum(String expression, int expected) {
        int result = StringAddCalculator.sum(expression);
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("문자열에 공백또는 null이 들어올 경우 0을 리턴")
    void numberIsBlankAndNull() {
        int result = StringAddCalculator.sum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.sum("");
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.sum(" ");
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("숫자 하나만 입력할 경우 해당 숫자 반환")
    @CsvSource(value = {"10:10", "50:50", "1:1"}, delimiter = ':')
    void numberSizeIsOne(String number, int expected) {
        int result = StringAddCalculator.sum(number);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("커스텀 구분자로 입력값 덧셈")
    void cumtomDelimiter() {
        int result = StringAddCalculator.sum("//@\n1@2@3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("계산식에 음수가 들어올 경우 RuntimeException 발생")
    void numberIsNegativeQuantityCheck() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    StringAddCalculator.sum("-1,2,3");
                });
    }

}
