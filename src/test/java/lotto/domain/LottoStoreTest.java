package lotto.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.core.LottoGenerator;
import lotto.domain.core.WinLotto;

import static lotto.domain.LottoStoreTest.LottoStore.ERROR_MESSAGE_CHECK_PURCHASE_AMOUNT;
import static lotto.domain.LottoWinningAndPrizeMoney.FIFTH;
import static lotto.domain.core.LottoGenerator.from;
import static lotto.domain.core.LottoGenerator.winLotto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoStoreTest {

    @DisplayName("로또 구매 금액은 0보다 적을수 없음")
    @Test
    void lotto_purchaseAmount() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> LottoStore.purchaseAutoLotto(0))
            .withMessage(ERROR_MESSAGE_CHECK_PURCHASE_AMOUNT);

        assertThatIllegalArgumentException()
            .isThrownBy(() -> LottoStore.purchaseAutoLotto(-10))
            .withMessage(ERROR_MESSAGE_CHECK_PURCHASE_AMOUNT);
    }

    @DisplayName("로또는 한장에 1,000원으로 입력한 금액과 1,000을 나눠서 로또를 자동 생성함")
    @Test
    void lotto_purchase() {
        LottoStore lottoStore = LottoStore.purchaseAutoLotto(14_000);
        assertThat(lottoStore.countOfPurchased()).isEqualTo(14);
    }

    @DisplayName("로또 당첨 통계 정보 확인")
    @Test
    void statistics() {
        WinLotto wonLotto = winLotto(from(1, 2, 3, 4, 5, 6));
        ImmutableLottoList lottos = ImmutableLottoList.builder()
                                                      .lotto(LottoGenerator.from(8, 21, 23, 41, 42, 43))
                                                      .lotto(LottoGenerator.from(3, 5, 11, 16, 32, 38))
                                                      .lotto(LottoGenerator.from(7, 11, 16, 35, 36, 44))
                                                      .lotto(LottoGenerator.from(1, 8, 11, 31, 41, 42))
                                                      .lotto(LottoGenerator.from(1, 3, 5, 14, 22, 45))
                                                      .build()
            ;

        LottoStore lottoStore = new LottoStore(14_000, lottos);
        LottoStatistics statistics = lottoStore.getStatistics(wonLotto);
        assertThat(statistics.getTotalMatchCount(FIFTH)).isEqualTo(1);

        int expectedPrizeMoney =  5_000;
        assertThat(statistics.getTotalWinPrizeMoney()).isEqualTo(expectedPrizeMoney);
        assertThat(statistics.getGrossProfit()).isEqualTo(0.35);
    }

    public static class LottoStore {
        public static final String ERROR_MESSAGE_CHECK_PURCHASE_AMOUNT = "로또 구매금액은 0보다 커야 합니다.";
        private static final int ZERO = 0;
        private final LottoPurchase lottoPurchase;
        private final ImmutableLottoList lottos;

        private static void verifyPurchaseAmount(int purchaseAmount) {
            if (ZERO >= purchaseAmount) {
                throw new IllegalArgumentException(ERROR_MESSAGE_CHECK_PURCHASE_AMOUNT);
            }
        }

        LottoStore(int purchaseAmount) {
            verifyPurchaseAmount(purchaseAmount);
            lottoPurchase = LottoPurchase.buyAllAuto(purchaseAmount);
            lottos = ImmutableLottoList.builder()
                                       .autoLottos(lottoPurchase.getAutoLottoGeneratedCount())
                                       .build()
            ;
        }

        LottoStore(int purchaseAmount, ImmutableLottoList lottos) {
            verifyPurchaseAmount(purchaseAmount);
            this.lottoPurchase = LottoPurchase.buyAllAuto(purchaseAmount);
            this.lottos = lottos;
        }

        public static LottoStore purchaseAutoLotto(int purchaseAmount) {
            return new LottoStore(purchaseAmount);
        }

        public int countOfPurchased() {
            return lottos.size();
        }

        public LottoStatistics getStatistics(WinLotto winLotto){
            List<LottoWinningAndPrizeMoney> allMatchCount = lottos.compareToEachLottoWithWonLotto(winLotto);
            return LottoStatistics.fromAllMatchCount(lottoPurchase, allMatchCount);
        }
    }
}
