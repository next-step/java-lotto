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

    public static final Integer BONUS_NUMBER = 7;
    private static final List<Integer> WINNING_NUMBERS = List.of(1, 2, 3, 4, 5, 6);
    private static final LottoGenerator LOTTO_RULE = new LottoGenerator(1, 6, 6);

    @DisplayName("구매 금액에 해당하는 갯수의 로또 발급")
    @CsvSource(value = {"1000, 1000, 1", "14000, 2000, 7", "5000, 5000, 1"})
    @ParameterizedTest
    void createLotto(int inputAmount, int lottoPrice, int expected) {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount(inputAmount);
        LottoPurchaseManager lottoPurchaseManager = new LottoPurchaseManager(purchaseAmount, lottoPrice, 0);

        // when
        LottoGame lottoGame = new LottoGame(lottoPurchaseManager, LOTTO_RULE);
        LottoGameResult lottoGameResult = lottoGame.play(WINNING_NUMBERS, BONUS_NUMBER);

        // then
        Assertions.assertThat(lottoGameResult.lottoCount()).isEqualTo(expected);
    }

    @DisplayName("로또 결과 반환")
    @Test
    void playLotto() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(10000);
        int lottoPrice = 1000;
        LottoPurchaseManager lottoPurchaseManager = new LottoPurchaseManager(purchaseAmount, lottoPrice, 0);

        LottoGame lottoGame = new LottoGame(lottoPurchaseManager, LOTTO_RULE);
        LottoGameResult result = lottoGame.play(WINNING_NUMBERS, BONUS_NUMBER);

        int actual = 0;
        for (RankType rank: RankType.values()) {
            actual += result.getRankCounters().getCount(rank);
        }
        Assertions.assertThat(actual).isEqualTo(result.lottoCount());
    }

    @DisplayName("당첨금 계산")
    @Test
    void calculateWinningAmountTest() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(10000);
        int lottoPrice = 1000;
        LottoPurchaseManager lottoPurchaseManager = new LottoPurchaseManager(purchaseAmount, lottoPrice, 0);

        LottoGame lottoGame = new LottoGame(lottoPurchaseManager, LOTTO_RULE);
        LottoGameResult result = lottoGame.play(WINNING_NUMBERS, BONUS_NUMBER);

        long actual = result.getWinningsSum();
        long expected = RankType.FIRST.getTotalWinnings(10);

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}