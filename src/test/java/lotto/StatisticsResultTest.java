package lotto;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class StatisticsResultTest {
    @Test
    public void 구매금액5000원_수익5000원() {
        // given
        FixedLottoGenerator fixedLottoGenerator = new FixedLottoGenerator("1, 2, 3, 4, 5, 6");
        PurchaseHistory purchaseHistory = new PurchaseHistory(5000, fixedLottoGenerator);
        WinningLotto lotto = (WinningLotto) new FixedLottoGenerator("1, 2, 3, 40, 41, 42").generateLotto();
        // when
        StatisticsResult statisticsResult = new StatisticsResult(purchaseHistory, lotto);
        // then
        assertThat(statisticsResult.getRateOfReturn()).isEqualTo(1);
    }

    @Test
    public void 구매금액2000원_수익5000원() {
        // given
        FixedLottoGenerator fixedLottoGenerator = new FixedLottoGenerator("1, 2, 3, 4, 5, 6");
        PurchaseHistory purchaseHistory = new PurchaseHistory(2000, fixedLottoGenerator);
        WinningLotto lotto = (WinningLotto) new FixedLottoGenerator("1, 2, 3, 40, 41, 42").generateLotto();
        // when
        StatisticsResult statisticsResult = new StatisticsResult(purchaseHistory, lotto);
        // then
        assertThat(statisticsResult.getRateOfReturn()).isEqualTo(2.5);
    }

    @Test
    public void 보너스볼2등_수익30000000원() {
        // given
        FixedLottoGenerator fixedLottoGenerator = new FixedLottoGenerator("1, 2, 3, 4, 5, 6");
        PurchaseHistory purchaseHistory = new PurchaseHistory(2000, fixedLottoGenerator);
        WinningLotto lotto = (WinningLotto) new FixedLottoGenerator("1, 2, 3, 4, 5, 8", 6).generateLotto();
        // when
        StatisticsResult statisticsResult = new StatisticsResult(purchaseHistory, lotto);
        // then
        assertThat(statisticsResult.getRateOfReturn()).isEqualTo(30000);
    }
}