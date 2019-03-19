package lotto;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class StatisticsResultTest {
    @Test
    public void 구매금액5000원_수익5000원() {
        // given
        FixedLottoGenerator fixedLottoGenerator = new FixedLottoGenerator(1);
        PurchaseHistory purchaseHistory = new PurchaseHistory(5000, fixedLottoGenerator);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 40, 41, 42));
        // when
        StatisticsResult statisticsResult = purchaseHistory.compareWith(lotto);
        // then
        assertThat(statisticsResult.getRateOfReturn()).isEqualTo(1);
    }

    @Test
    public void 구매금액2000원_수익5000원() {
        // given
        FixedLottoGenerator fixedLottoGenerator = new FixedLottoGenerator(1);
        PurchaseHistory purchaseHistory = new PurchaseHistory(2000, fixedLottoGenerator);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 40, 41, 42));
        // when
        StatisticsResult statisticsResult = purchaseHistory.compareWith(lotto);
        // then
        assertThat(statisticsResult.getRateOfReturn()).isEqualTo(2.5);
    }
}