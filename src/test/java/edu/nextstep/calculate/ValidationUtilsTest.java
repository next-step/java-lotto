package edu.nextstep.calculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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


}