package lotto.domain;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AnalyzerTest {

    @Test
    public void winningPrices_반환_테스트() {
        Analyzer analyzer = new Analyzer(new Price(1000));
        analyzer.calculateTotalWinningMoney(
            Arrays.asList(new WinningResult(3, 0), new WinningResult(3, 0)));
        Assertions.assertThat(analyzer.calculateProfitPercent()).isEqualTo(10.0);
    }
}
