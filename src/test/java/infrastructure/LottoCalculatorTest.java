package infrastructure;

import domain.LottoCalculator;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCalculatorTest {
    @Test
    public void 수익률계산() {
        int price = 1000;
        List<Integer> results = Arrays.asList(0, 0, 0, 0, 0, 0, 0);
        results.set(3, 1);

        LottoCalculator calculator = new LottoCalculator();
        double profit = calculator.run(results, price);

        assertThat(profit).isEqualTo(5);
    }

    @Test
    public void 수익률계산_소수() {
        int price = 14000;
        List<Integer> results = Arrays.asList(0, 0, 0, 0, 0, 0, 0);
        results.set(3, 1);

        LottoCalculator calculator = new LottoCalculator();
        double profit = calculator.run(results, price);

        assertThat(profit).isEqualTo(0.36);
    }
}