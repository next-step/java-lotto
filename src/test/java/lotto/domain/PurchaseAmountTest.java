package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountTest {
    private static final int TICKET_AMOUNT = 1000;

    @Test
    @DisplayName("구매 금액이 음수이면 에러가 발생한다.")
    void validatePurchaseAmount() {
        assertThatThrownBy(() -> new PurchaseAmount(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("티켓 금액보다 적은 금액을 넣을 경우, 에러가 발생한다.")
    void buyLottoTicketWithUnaffordableAmount() {
        assertThatThrownBy(() -> new PurchaseAmount(TICKET_AMOUNT-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입 금액을 장당 가격으로 나누었을 때, 정수가 아니면 에러를 반환한다.")
    void validateAmount() {
        assertThatThrownBy(() -> new PurchaseAmount(TICKET_AMOUNT+1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("상품 금액을 입력하면 구매할 수 있는 수량을 반환한다.")
    void getTicketCount() {
        assertThat(new PurchaseAmount(1000).getTicketCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("총수익률을 반환한다")
    void getReturnRate() {
        PurchaseAmount amount = new PurchaseAmount(1000);
        assertThat(amount.getReturnRate(4000)).isEqualTo(4);
    }
}