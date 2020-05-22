package lotto.domain.shop;

import lotto.domain.lotto.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ShopTests {
    @DisplayName("돈을 내면 몇 개의 로또 티켓을 살 수 있는지 계산한다.")
    @ParameterizedTest
    @CsvSource(value = { "10000:10", "11000:11", "12000:12" }, delimiter = ':')
    void getLottoTicketCountTest(int moneyValue, int count) {
        int lottoTicketCount = Shop.getLottoTicketCount(new Money(moneyValue));
        assertThat(lottoTicketCount).isEqualTo(count);
    }

    @DisplayName("낸 돈으로 최대한 살 수 있는 LottoTicket을 판매한다.")
    @Test
    void sellLottoTickets() {
        LottoTickets lottoTickets = Shop.buyLottoTickets(new Money(10000));
        assertThat(lottoTickets.size()).isEqualTo(10);
    }
}
