package lotto;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputeEarningsRateTest {

    @Test
    public void 수익률계산() {
        double result = ComputeEarningsRate.computeEarningRate(5000,14000);

        assertThat(String.format("%.2f", result)).isEqualTo("0.36");
    }

    @Test
    public void 수익계산(){
        Map<LottoType,Integer> winnings = new HashMap<>();
        winnings.put(LottoType.THREE,5);

        double earnings = ComputeEarningsRate.computeEarning(winnings,0.0);

        assertThat(earnings).isEqualTo(25000.0);
    }
}