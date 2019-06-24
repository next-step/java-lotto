package edu.nextstep.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-lotto
 * create date  : 2019-06-24 22:48
 */
public class NumberTest {

    @DisplayName("객체 생성시 원시타입이 위배되는지 확인 - 0이하 예외처리")
    @Test
    void validNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
           Number number = new Number(0);
        });
    }

    @DisplayName("객체의 원시타입 숫자를 반환 받기")
    @Test
    void getNumber() {
        Number number = new Number(1);
        assertThat(number.getNumber()).isEqualTo(1);
    }
}
