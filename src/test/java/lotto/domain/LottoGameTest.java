package lotto.domain;

import static lotto.domain.LottoRank.FIFTH;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest {
    @DisplayName("자동로또 발급")
    @Test
    void 자동로또_발급() {
        LottoGame lottoGame = new LottoGame(new LottoPrice(30000));
        assertThat(lottoGame.getLottos()).hasSize(30);
    }

    @DisplayName("수동로또 발급")
    @Test
    void 수동로또_발급() {
        LottoPrice lottoPrice = new LottoPrice(30000);
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        List<Lotto> lottoList = new ArrayList<>(Arrays.asList(lotto, lotto, lotto));
        LottoGame lottoGame = new LottoGame(lottoPrice, new LottoCount(lottoPrice, 0), lottoList);
        assertThat(lottoGame.getLottos()).hasSize(30);
    }

    @DisplayName("수익률 구하기")
    @Test
    void 로또_수익률_구하기() {
        LottoResults lottoResults = new LottoResults();
        lottoResults.addResult(FIFTH);

        LottoPrice lottoPrice = new LottoPrice(14000);

        LottoGame lottoGame = new LottoGame(lottoPrice, new LottoCount(lottoPrice, 0), new ArrayList<>(), lottoResults);
        assertThat(lottoGame.getEarnRate()).isEqualTo("0.35");
    }
}
