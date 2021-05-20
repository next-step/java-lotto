package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWalletTest {

    @DisplayName("로또의 구입가능한 갯수 및 구입결과 확인 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,5,10})
    public void createLottoWallet(int countOfBuyLotto) {
        LottoWallet lottoWallet = new LottoWallet(countOfBuyLotto);
        lottoWallet.buyLotto();

        assertThat(lottoWallet.lottoTickets()).hasSize(countOfBuyLotto);
        assertThat(lottoWallet.ticketCount()).isEqualTo(countOfBuyLotto);
    }
}
