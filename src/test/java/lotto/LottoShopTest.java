package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoShopTest {

    @DisplayName("원하는 개수만큼의 로또 티켓을 만든다.")
    @Test
    void createLottoTicketAsYouWant() {
        MoneyWallet moneyWallet = new MoneyWallet(10000);
        LottoWallet lottoWallet = LottoShop.buy(moneyWallet);
        assertThat(lottoWallet.totalTicketCount()).isEqualTo(10);
    }
}
