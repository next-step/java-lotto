package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class PurchaseActionTest {

    @Test
    void 구매금액이_1000원_미만이면_에러가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAction(500))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매금액이_주어지면_로또티켓이_생성된다() {
        PurchaseAction purchaseAction = new PurchaseAction(14_000);
        Tickets tickets = purchaseAction.purchase();

        assertThat(tickets).isNotNull();
    }

}
