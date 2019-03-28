package lotto;

import lotto.domain.Lottos;
import lotto.domain.LottosResult;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.domain.generator.LottoGenerator;
import lotto.domain.generator.ManualLottoGenerator;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottosResultAndRateTest {
    ManualLottoGenerator lottoGenerator;
    List<String> manual;

    @Test
    public void 구매금액5000원_수익5000원() {
        // given
        Money payment = new Money(5000);
        manual = Arrays.asList("1, 2, 3, 4, 5, 6", "2, 3, 4, 5, 6, 7", "3, 4, 5, 6, 7, 8", "4, 5, 6, 7, 8, 9", "5, 6, 7, 8, 9, 10");
        lottoGenerator = new ManualLottoGenerator(manual);
        Lottos purchaseHistory = lottoGenerator.generateLottos();
        WinningLotto lotto = LottoGenerator.generateWinningLotto("1, 2, 3, 40, 41, 42", 43);
        // when
        LottosResult statisticsResult = new LottosResult(purchaseHistory, lotto);
        // then
        assertThat(statisticsResult.getRateOfReturn()).isEqualTo(1);
    }

    @Test
    public void 구매금액2000원_수익5000원() {
        // given
        Money payment = new Money(2000);
        manual = Arrays.asList("1, 2, 3, 4, 5, 6", "2, 3, 4, 5, 6, 7");
        lottoGenerator = new ManualLottoGenerator(manual);
        Lottos purchaseHistory = lottoGenerator.generateLottos();
        WinningLotto lotto = LottoGenerator.generateWinningLotto("1, 2, 3, 40, 41, 42", 43);
        // when
        LottosResult statisticsResult = new LottosResult(purchaseHistory, lotto);
        // then
        assertThat(statisticsResult.getRateOfReturn()).isEqualTo(2.5);
    }

    @Test
    public void 보너스볼2등_수익30000000원() {
        // given
        Money payment = new Money(1000);
        manual = Arrays.asList("1, 2, 3, 40, 41, 6");
        lottoGenerator = new ManualLottoGenerator(manual);
        Lottos purchaseHistory = lottoGenerator.generateLottos();
        WinningLotto lotto = LottoGenerator.generateWinningLotto("1, 2, 3, 40, 41, 42", 6);
        // when
        LottosResult statisticsResult = new LottosResult(purchaseHistory, lotto);
        // then
        assertThat(statisticsResult.getRateOfReturn()).isEqualTo(30000);
    }
}