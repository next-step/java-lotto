package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import lotto.domain.game.Payment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PaymentTest {

    @DisplayName("투입 금액이 부족하면 예외 발생")
    @Test()
    void 최소_투입_금액_검증() {
        int value1 = 999;

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Payment(value1))
            .withMessage("구입 금액이 부족합니다");

    }

    @DisplayName("구입 가능한 자동 로또 갯수 반환")
    @Test
    void 자동_로또_구입_갯수() {
        int value1 = 12000;
        int manualLottoCount1 = 10;
        int value2 = 10000;
        int manualLottoCount2 = 10;

        Payment payment1 = new Payment(value1);
        Payment payment2 = new Payment(value2);

        assertThat(payment1.calculateBuyCount(manualLottoCount1)).isEqualTo(2);
        assertThat(payment2.calculateBuyCount(manualLottoCount2)).isEqualTo(0);
    }

    @DisplayName("투입 금액")
    @Test
    void calcaulteProfitRate() {
        int value = 12000;
        Payment payment = new Payment(value);

        double profit = 3000;

        assertThat(payment.calculateProfitRate(profit)).isEqualTo(0.25);
    }

    @DisplayName("투입 금액 이하의 로또를 살 수 있는지 확인")
    @Test
    void isMoney() {
        int value = 12000;
        Payment payment = new Payment(value);
        int count = 12;

        assertThat(payment.isBuy(count)).isTrue();
    }

}
