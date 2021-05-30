package lotto;

import lotto.domain.LottoGame;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @Test
    public void availablePurchaseLottoCount_구매가능매수확인() {
        LottoGame lottoGame = new LottoGame();
        int lottoCount = lottoGame.availablePurchaseLottoCount(14000);
        assertThat(lottoCount).isEqualTo(14);
    }

    @Test
    public void purchaseAvailableLotto_구매로또개수생성검증() {
        LottoGame lottoGame = new LottoGame();
        assertThat(lottoGame.purchaseAvailableLotto(14).count()).isEqualTo(14);
    }
}
