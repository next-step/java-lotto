package lotto.domain.shop;

import lotto.domain.lotto.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ShopTests {
    @DisplayName("낸 돈으로 최대한 살 수 있는 LottoTicket을 판매한다.")
    @Test
    void sellLottoTickets() {
        LottoTickets lottoTickets = Shop.sellLottoTickets(new Money(10000));
        assertThat(lottoTickets.size()).isEqualTo(10);
    }
}
