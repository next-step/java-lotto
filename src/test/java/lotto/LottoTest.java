package lotto;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void 구매금액만큼_로또를_최대치_구입한다() {
        int lottoPrice = 1000;
        int purchaseBudget = 14000;

        LottoGame lottoGame = new LottoGame(lottoPrice, purchaseBudget);
        assertThat(lottoGame.hasLottoCount()).isEqualTo(purchaseBudget / lottoPrice);
    }

    @Test
    void 몇개_맞았는지_계산해주기() {
        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto myLotto = new Lotto( List.of(1, 2, 3, 7, 8, 9));

        int matchedCount = winLotto.countMatchedNumber(myLotto);

        assertThat(matchedCount).isEqualTo(3);
    }

    /**
     * 수익률 = 총 당첨 금액 / 구입 금액
     */
    @Test
    void statistics_on_matched_count() {
        long purchase = 14000L;

        Map<RANK, Integer> lotteryWin = new HashMap<>();
        lotteryWin.put(RANK.FOURTH, 1);
        lotteryWin.put(RANK.THIRD, 0);
        lotteryWin.put(RANK.SECOND, 0);
        lotteryWin.put(RANK.FIRST, 0);

        long totalPrize = lotteryWin.keySet().stream().mapToLong(key -> key.winPrize(lotteryWin.get(key))).sum();

        double actual = Math.floor((double) totalPrize / purchase * 100) / 100.0 ;
        assertThat(actual).isEqualTo(0.35);
    }
}