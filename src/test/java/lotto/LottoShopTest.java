package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
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

    @DisplayName("개수만큼의 로또 티켓을 만들고 난 후엔 돈이 줄어든다.")
    @Test
    void withdrawMoneyAfterBoughtLotto(){
        MoneyWallet moneyWallet = new MoneyWallet(10000);
        LottoWallet lottoWallet = LottoShop.buy(moneyWallet);
        moneyWallet = lottoWallet.withdrawMoney(moneyWallet);
        Assertions.assertThat(moneyWallet.balance()).isEqualTo(0);
    }
}
