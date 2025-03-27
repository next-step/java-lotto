package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.domain.lotto.LottoFactory;
import step2.domain.lotto.LottoGenerator;
import step2.domain.lotto.Rank;
import step2.domain.lotto.WinningLotto;

import java.util.List;

class LottoGameResultTest {

    private static final WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
    private static final LottoGenerator lottoGenerator = new LottoGenerator(1, 45, 6);
    private static final LottoFactory lottoFactory = new LottoFactory(lottoGenerator);

    @DisplayName("구매 금액에 해당하는 갯수의 로또 발급")
    @CsvSource(value = {"1000, 1000, 1", "14000, 2000, 7", "5000, 5000, 1"})
    @ParameterizedTest
    void createLotto(int purchaseAmount, int lottoPrice, int expected) {
        // when
        LottoGame lottoGame = new LottoGame(purchaseAmount, lottoPrice, winningLotto, lottoFactory);
        LottoGameResult lottoGameResult = lottoGame.play();

        // then
        Assertions.assertThat(lottoGameResult.lottoCount()).isEqualTo(expected);
    }

    @DisplayName("로또 결과 반환")
    @Test
    void playLotto() {
        int purchaseAmount = 10000;
        int lottoPrice = 1000;

        LottoGame lottoGame = new LottoGame(purchaseAmount, lottoPrice, winningLotto, lottoFactory);
        LottoGameResult result = lottoGame.play();

        int actual = 0;
        for (Rank rank: Rank.values()) {
            actual += result.getRankCounters().getCount(rank);
        }
        Assertions.assertThat(actual).isEqualTo(result.lottoCount());
    }
}