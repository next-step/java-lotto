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

    @DisplayName("투입금액 / 1000을 통해 발행 개수를 확인한다.")
    @Test
    void getNumberOfExtract() {
        Money money = new Money(10000, 0);
        assertThat(money.getNumberOfExtract()).isEqualTo(10);
    }

    @DisplayName("Money 객체 생성 예외상황 - 나누는 기준 값보다 작을 경우")
    @Test
    void validMoney() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Money money = new Money(999, 0);
        });
    }

    @DisplayName("Money 객체에 수동생성 카운트 가지고 오기")
    @Test
    void getNumberOfManual() {
        Money money = new Money(10000, 3);
        assertThat(money.getNumberOfManual()).isEqualTo(3);
    }
}
