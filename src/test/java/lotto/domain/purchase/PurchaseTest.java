package lotto.domain.purchase;

import lotto.domain.lotto.ticket.LottoTicket;
import lotto.domain.lotto.ticket.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PurchaseTest {

    @Test
    @DisplayName("구매한 상품의 개수 테스트")
    void 구매_테스트() {
        int money = 1000;
        Purchase sale = new Purchase(money, null, new LottoTickets());

        assertThat(sale.purchaseLottoCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("구매 생성자 에러 테스트 - 돈이 부족한 경우")
    void 구매_생성자_에러_테스트() {
        int money = 999;
        assertThatThrownBy(() -> new Purchase(money, null, new LottoTickets()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("돈이 부족합니다.");
    }

    @Test
    @DisplayName("")
    void 로또_구매_개수() {
        Purchase purchase = new Purchase(2000, () -> new LottoTicket(1, 2, 3, 4, 5, 6), new LottoTickets());

        assertThat(purchase.purchaseLotto()).isEqualTo(new LottoTickets(List.of(new LottoTicket(1, 2, 3, 4, 5, 6), new LottoTicket(1, 2, 3, 4, 5, 6))));
    }
}
