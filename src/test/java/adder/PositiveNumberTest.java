package adder;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PositiveNumberTest {

    @Test
    @DisplayName("입력값이 null 인 경우")
    public void nullInput() {
        // given
        String number = null;
        String message = PositiveNumber.NON_NULL;

        // when
        ThrowingCallable throwingCallable = () -> new PositiveNumber(number);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @ParameterizedTest(name = "숫자가 아닌 경우 | {arguments}")
    @CsvSource(value = {"iiaii|iiaii", ":|:", "$|$"}, delimiter = '|')
    public void notNumber(String number, String notNumber) {
        // given
        String message = PositiveNumber.NOT_NUMBER + notNumber;

        // when
        ThrowingCallable throwingCallable = () -> new PositiveNumber(number);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @ParameterizedTest(name = "음수인 경우 | {arguments}")
    @CsvSource(value = {"-1|-1", "-10|-10"}, delimiter = '|')
    public void negativeNumber(String number, String negativeNumber) {
        // given
        String message = PositiveNumber.NEGATIVE_NUMBER + negativeNumber;

        // when
        ThrowingCallable throwingCallable = () -> new PositiveNumber(number);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("입력값이 비어있는 경우")
    public void blankInput() {
        // given
        String number = "";
        PositiveNumber expectedPositiveNumber = new PositiveNumber("0");

        // when
        PositiveNumber positiveNumber = new PositiveNumber(number);

        // then
        assertThat(positiveNumber).isEqualTo(expectedPositiveNumber);
    }

    @ParameterizedTest(name = "PositiveNumber 생성 | {arguments}")
    @CsvSource(value = {"3|3", "10|10"}, delimiter = '|')
    public void createPositiveNumber(String number, String expectedNumber) {
        // given
        PositiveNumber expectedPositiveNumber = new PositiveNumber(expectedNumber);

        // when
        PositiveNumber positiveNumber = new PositiveNumber(number);

        // then
        assertThat(positiveNumber).isEqualTo(expectedPositiveNumber);
    }

}