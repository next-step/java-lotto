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
                }).withMessageMatching("Invalid purchase amount");
    }

    @Test
    @DisplayName("구입금액이 0보다 작은경우 예외처리를 확인한다")
    void checkException2() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    PurchaseAmount.of(0L);
                }).withMessageMatching("Invalid purchase amount");
    }

    @Test
    @DisplayName("최대 구입가능금액 이상인경우 예외처리를 확인한다")
    void checkException3() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    PurchaseAmount.of(100000001L);
                }).withMessageMatching("Invalid purchase amount");
    }

    @Test
    @DisplayName("구입금액당 티켓수를 정상적으로 발급하는지 확인한다")
    void checkNumberOfTickets() {
        PurchaseAmount purchaseAmount = PurchaseAmount.of(1100L);
        assertThat(purchaseAmount.getNumberOfTickets()).isEqualTo(1);
    }
}
