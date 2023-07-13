package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import lotto.domain.Payment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PaymentTest {

    @DisplayName("투입한 금액이 1,000원 미만이면 예외 발생한다")
    @Test()
    void 최소_투입_금액_검증() {
        int value = 999;

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Payment(value))
            .withMessage("1,000원 이상 투입해 주세요");
    }

    @DisplayName("투입한 금액만큼 로또 구매 갯수를 반환한다")
    @Test
    void 로또_구입_갯수() {
        int value1 = 12000;
        int value2 = 1000;

        Payment payment1 = new Payment(value1);
        Payment payment2 = new Payment(value2);

        assertThat(payment1.getLottoCount()).isEqualTo(12);
        assertThat(payment2.getLottoCount()).isEqualTo(1);
    }

}
