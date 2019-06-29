package edu.nextstep.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
 * create date  : 2019-06-25 00:23
 */
public class MoneyTest {

    @DisplayName("Money 객체 생성 예외상황 - 나누는 기준 값보다 작을 경우")
    @Test
    void validMoney() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Money money = new Money(999);
        }).withMessageContaining("투입금액이 적습니다.");
    }

    @DisplayName("Money 객체 생성 예외상황 - 나누는 기준 값보다 작을 경우")
    @Test
    void getAutoNumber() {
        Money money = new Money(2_000);
        assertThat(money.getAutoNumber(1)).isEqualTo(1);
    }
}
