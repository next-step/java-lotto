package step2.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BuyLottoTest {

    @DisplayName("구입 가격에 맞는 로또 개수를 구매하는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1001 :1",
            "12780 :12",
            "1999 :1",
            "234567 : 234" }, delimiter = ':')
    public void buy_Lotto_Test(int money, int buyAmount) {
        BuyLotto buyLotto = new BuyLotto(money, 0);
        assertThat(buyLotto.getLottoQuantity()).isEqualTo(buyAmount);
    }

    @DisplayName("구매 수량에 맞는 로또 번호를 생성하는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1001 :1",
            "12780 :12",
            "1999 :1",
            "234567 :234" }, delimiter = ':')
    public void lotto_Ticket_Test(int money, int buyAmount) {
        BuyLotto buyLotto = new BuyLotto(money, buyAmount);

        Lottos lottoTicket = buyLotto.lottoTicket(Arrays.asList("1,2,3,4,5,6", "1,2,3,4,5,6", "1,2,3,4,5,6", "1,2,3,4,5,6"));

        assertThat(lottoTicket.getLottos()).hasSize(buyAmount);
    }
}