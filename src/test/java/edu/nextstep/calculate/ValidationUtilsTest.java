package edu.nextstep.calculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-lotto
 * create date  : 2019-06-22 02:13
 */
class ValidationUtilsTest {

    @DisplayName("문자열의 유효성체크 (공백)")
    @Test
    void isSpace() {

        assertThat(ValidationUtils.isSpace("")).isTrue();
    }

    @DisplayName("숫자가 맞는지 체크")
    @Test
    void isNumber() {

        assertThat(ValidationUtils.isNumber("1")).isTrue();
    }

    @DisplayName("음수인지 체크")
    @Test
    void isNegativeNumber() {

        assertThat(ValidationUtils.isNegativeNumber(-1)).isTrue();
    }

    @DisplayName("음수 or 숫자가아니면 RuntimeException 처리")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "a"})
    void validationNumber(String inValidChar) {

        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
           ValidationUtils.validationNumber(inValidChar);
        });
    }


}