package deprecatedlotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitMarginTest {


    public static final double EXPECTED_TEST_MARGIN = 0.35;
    public static final int TEST_WINNING_AMOUNT = 5000;
    public static final int TEST_PURCHASE_AMOUNT = 14000;

    @Test
    void 수익률계산테스트() {
        int winningAmount = TEST_WINNING_AMOUNT;
        int purchaseAmount = TEST_PURCHASE_AMOUNT;
        ProfitMargin profitMargin = new ProfitMargin(winningAmount, purchaseAmount);
        assertThat(profitMargin.calculateMargin()).isEqualTo(EXPECTED_TEST_MARGIN);
    }

}
