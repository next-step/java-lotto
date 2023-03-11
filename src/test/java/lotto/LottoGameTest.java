package lotto;

import lotto.domain.LottoGame;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGameTest {
    @DisplayName("입력 받은 금액의 최대 구매금액을 구한다.")
    @Test
    void getLottoGame() {
        LottoGame lottoGame = new LottoGame(3500);
        int lottosPrice = lottoGame.getBuyPrice();
        Assertions.assertThat(lottosPrice).isEqualTo(3000);
    }

    @DisplayName("로또 당첨번호들을 반환한다.")
    @Test
    void getLottosNumbers() {
        LottoGame lottoGame = new LottoGame(14000);

        lottoGame.getAllLottoNumbers();
    }

}
