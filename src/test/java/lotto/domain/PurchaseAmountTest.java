package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PurchaseAmountTest {

    @Test
    @DisplayName("구입금액이 0원인경우 예외처리를 확인한다")
    void checkException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    PurchaseAmount.of(0L);
                }).withMessageMatching("Must be greater than 0");
    }

    @Test
    @DisplayName("구입금액당 티켓수를 정상적으로 발급하는지 확인한다")
    void checkNumberOfTickets() {
        PurchaseAmount purchaseAmount = PurchaseAmount.of(1100L);
        assertThat(purchaseAmount.getNumberOfTickets()).isEqualTo(1);
    }
}
