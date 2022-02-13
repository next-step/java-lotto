package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class AnalyzerTest {

    @Test
    public void winningPrices_반환_테스트() {
        Analyzer analyzer = new Analyzer(1000);
        analyzer.calculateTotalWinningMoney(
            Arrays.asList(new WinningResult(3, 0)));
        List<WinningPrice> winningPrices = analyzer.getWinningPrices();
        assertThat(winningPrices.get(0)).isEqualTo(WinningPrice.THREE);

    }

}
