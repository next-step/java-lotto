package Lotto.Lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @ParameterizedTest
    @CsvSource(value = {"1,0,0,0,2000,2.5", "10,2,0,0,1000000,0.15"}, delimiter = ',')
    public void profitTest(final Integer fourthCount, final Integer thirdCount, final Integer secondCount,
                           final Integer firstCount, final Integer buyMoney, final Float profit) {
        LottoMoney lottoMoney = new LottoMoney(buyMoney);
        LottoResult lottoResult = new LottoResult(lottoMoney);
        lottoResult.setCount(LottoReward.FOURTH, fourthCount);
        lottoResult.setCount(LottoReward.THIRD, thirdCount);
        lottoResult.setCount(LottoReward.SECOND, secondCount);
        lottoResult.setCount(LottoReward.FIRST, firstCount);
        assertThat(lottoResult.profit()).isEqualTo(profit);
    }
}
