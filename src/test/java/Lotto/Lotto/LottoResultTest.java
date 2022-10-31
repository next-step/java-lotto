package Lotto.Lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @ParameterizedTest
    @CsvSource(value = {"1,0,0,0=2000=2.5", "10,2,0,0=1000000=0.15"}, delimiter = '=')
    public void profitTest(final String rewards, final Integer buyMoney, final Float profit) {
        LottoResult lottoResult = new LottoResult(rewards, buyMoney);
        assertThat(lottoResult.profit()).isEqualTo(profit);
    }
}
