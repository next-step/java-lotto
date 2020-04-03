package lotto.domain.lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @DisplayName("입력금액에서 구매 가능한 로또만큼 구매 되는지 체크")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 10, 11, 100})
    public void play_success_countBuyLotto(int count) throws Exception {
        //given
        LottoGame lottoGame = new LottoGame();

        //when
        LottoTickets autoLottoTicket = lottoGame.createAutoLottoTicket(count);

        //then
        assertThat(autoLottoTicket.size()).isEqualTo(count);
    }

    @DisplayName("몇개의 로또 구매가 가능한지 체크")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "4444:4", "5999:5"}, delimiter = ':')
    public void getAvailableBuyCount_success(int moneyParam, int expect) throws Exception {
        //given
        Money money = new Money(moneyParam);
        LottoGame lottoGame = new LottoGame();

        //when
        int availableBuyCount = lottoGame.getAvailableBuyCount(money);

        //then
        assertThat(availableBuyCount).isEqualTo(expect);
    }
}
