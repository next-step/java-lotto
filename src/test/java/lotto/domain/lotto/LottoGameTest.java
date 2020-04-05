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
}
