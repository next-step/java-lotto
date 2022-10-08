package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import lotto.domain.exception.InvalidPurchasePriceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @Test
    @DisplayName("주어진 금액에 맞는 수만큼 자동 로또 생성")
    void get_automatic_tickets() {
        assertThat(LottoMachine.getAutomaticTickets(new PurchasePrice(14000))
                .getSize())
                .isEqualTo(14);
    }

    @Test
    @DisplayName("최소 금액 보다 적은 돈으로 자동 로또 생성 시 예외 발생")
    void fail_to_get_automatic_tickets_by_invalid_purchasePrice() {
        assertThatExceptionOfType(InvalidPurchasePriceException.class)
                .isThrownBy(() -> LottoMachine.getAutomaticTickets(new PurchasePrice(500)));
    }

}
