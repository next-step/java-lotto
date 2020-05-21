package lotto.domain.shop;

import lotto.domain.lotto.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ShopTests {
    @DisplayName("돈을 내면 몇 개의 로또 티켓을 살 수 있는지 계산한다.")
    @ParameterizedTest
    @CsvSource(value = { "10000:10", "11000:11", "12000:12" }, delimiter = ':')
    void getLottoTicketCountTest(int money, int count) {
        int lottoTicketCount = Shop.getLottoTicketCount(money);
        assertThat(lottoTicketCount).isEqualTo(count);
    }

    @DisplayName("1000원으로 나누어떨어지지 않는 금액으로 로또를 사려 하면 IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @ValueSource(longs = { 1111111L, 2222222L })
    void getLottoTicketCountFailWithInvalidMoney(long money) {
        assertThatThrownBy(() -> Shop.getLottoTicketCount(money)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0원으로 로또 티켓을 사려 하면 IllegalArgumentException이 발생한다.")
    @Test
    void getLottoTicketCountFailWithZero() {
        assertThatThrownBy(() -> Shop.getLottoTicketCount(0)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("낸 돈으로 최대한 살 수 있는 LottoTicket을 판매한다.")
    @Test
    void sellLottoTickets() {
        LottoTickets lottoTickets = Shop.buyLottoTickets(10000);
        assertThat(lottoTickets.size()).isEqualTo(10);
    }
}
