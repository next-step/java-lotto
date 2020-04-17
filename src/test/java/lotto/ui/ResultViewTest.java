package lotto.ui;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ResultViewTest {
    private static final int COUNT_OF_LOTTO = 14;

    @Test
    public void printEarningRate() {
        BigDecimal earningRate = new BigDecimal("0.35");
        ResultView.printEarningRate(earningRate.toString());
    }
}
