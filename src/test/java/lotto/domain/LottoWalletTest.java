package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoWalletTest {

    @DisplayName("로또의 구입가능한 갯수 및 구입결과 확인 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1000:1","1500:1","2000:2","10900:10"}, delimiter = ':')
    public void createLottoWallet(String inputMoney, int ticketCount) {
        Money money = Money.create(inputMoney);
        LottoWallet lottoWallet = LottoWallet.create(money);
        lottoWallet.buyingLotto(new TestNumberGeneratorStrategy());

        assertThat(lottoWallet.takeOutLottoTickets()).hasSize(ticketCount);
        assertThat(lottoWallet.getTicketCount()).isEqualTo(ticketCount);
    }

    @DisplayName("1000원 미만의 금액은 로또를 구입할수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "500", "999"})
    public void invalidAmountMoneyTest(String inputMoney) {
        Money money = Money.create(inputMoney);

        assertThatThrownBy(() -> LottoWallet.create(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
