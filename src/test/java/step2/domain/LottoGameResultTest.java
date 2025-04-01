package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.domain.lotto.*;
import step2.domain.rank.RankType;

import java.util.List;

class LottoGameResultTest {

    private static final WinningLotto WINNING_LOTTO = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
    private static final LottoRule LOTTO_RULE = new LottoRule(1, 6, 6);

    @DisplayName("구매 금액에 해당하는 갯수의 로또 발급")
    @CsvSource(value = {"1000, 1000, 1", "14000, 2000, 7", "5000, 5000, 1"})
    @ParameterizedTest
    void createLotto(int purchaseAmount, int lottoPrice, int expected) {
        // given
        LottoCount lottoCount = new LottoCount(purchaseAmount, lottoPrice);

        // when
        LottoGame lottoGame = new LottoGame(lottoCount, LOTTO_RULE);
        LottoGameResult lottoGameResult = lottoGame.play(WINNING_LOTTO);

        // then
        Assertions.assertThat(lottoGameResult.lottoCount()).isEqualTo(expected);
    }

    @DisplayName("로또 결과 반환")
    @Test
    void playLotto() {
        int purchaseAmount = 10000;
        int lottoPrice = 1000;
        LottoCount lottoCount = new LottoCount(purchaseAmount, lottoPrice);

        LottoGame lottoGame = new LottoGame(lottoCount, LOTTO_RULE);
        LottoGameResult result = lottoGame.play(WINNING_LOTTO);

        int actual = 0;
        for (RankType rank: RankType.values()) {
            actual += result.getRankCounters().getCount(rank);
        }
        Assertions.assertThat(actual).isEqualTo(result.lottoCount());
    }


    @DisplayName("당첨금 계산")
    @Test
    void calculateWinningAmountTest() {
        int purchaseAmount = 10000;
        int lottoPrice = 1000;
        LottoCount lottoCount = new LottoCount(purchaseAmount, lottoPrice);

        LottoGame lottoGame = new LottoGame(lottoCount, LOTTO_RULE);
        LottoGameResult result = lottoGame.play(WINNING_LOTTO);

        long actual = result.getWinningsSum();
        long expected = RankType.FIRST.getTotalWinnings(10);

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}