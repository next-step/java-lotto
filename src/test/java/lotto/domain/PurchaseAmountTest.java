package lotto.domain;

import lotto.common.PositiveNumber;
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
                    PurchaseAmount.of(PositiveNumber.of(0L));
                }).withMessageMatching("Invalid purchase amount");
    }

    @Test
    @DisplayName("구입금액이 0보다 작은경우 예외처리를 확인한다")
    void checkException2() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    PurchaseAmount.of(PositiveNumber.of(0L));
                }).withMessageMatching("Invalid purchase amount");
    }

    @Test
    @DisplayName("최대 구입가능금액 이상인경우 예외처리를 확인한다")
    void checkException3() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    PurchaseAmount.of(PositiveNumber.of(100000001L));
                }).withMessageMatching("Invalid purchase amount");
    }

    @Test
    @DisplayName("구입금액당 티켓수를 정상적으로 발급하는지 확인한다")
    void checkNumberOfTickets() {
        PurchaseAmount purchaseAmount = PurchaseAmount.of(PositiveNumber.of(1100L));
        assertThat(purchaseAmount.getNumberOfTickets().get()).isEqualTo(1);
    }

    @Test
    @DisplayName("수동티켓이 있는경우 전체 발급수를 확인한다")
    void checkNumberOfTickets2() {
        PurchaseAmount purchaseAmount = PurchaseAmount.ofManual(PositiveNumber.of(5500L), PositiveNumber.of(2));
        assertThat(purchaseAmount.getNumberOfTickets().get()).isEqualTo(5);
    }

    @Test
    @DisplayName("수동티켓이 있는경우 수동 발급수를 확인한다")
    void checkNumberOfTickets3() {
        PurchaseAmount purchaseAmount = PurchaseAmount.ofManual(PositiveNumber.of(5500L), PositiveNumber.of(2));
        assertThat(purchaseAmount.getNumberOfManualTickets().get()).isEqualTo(2);
    }

    @Test
    @DisplayName("수동티켓이 있는경우 자동 발급수를 확인한다")
    void checkNumberOfTickets4() {
        PurchaseAmount purchaseAmount = PurchaseAmount.ofManual(PositiveNumber.of(5500L), PositiveNumber.of(2));
        assertThat(purchaseAmount.getNumberOfAutoTickets().get()).isEqualTo(3);
    }

    @Test
    @DisplayName("구매금액을 초과하여 수동티켓을 발급한 경우를 확인한다")
    void exceedManualTicket() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    PurchaseAmount.ofManual(PositiveNumber.of(2000L), PositiveNumber.of(3));
                }).withMessageMatching("Purchase amount is insufficient");
    }
}
