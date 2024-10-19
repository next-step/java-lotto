package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberMatchCountTest {


    public static final double EXPECTED_TEST_MARGIN = 0.35;

    @Test
    void 수익률계산테스트() {
        int winningAmount = 5000;
        int purchaseAmount = 14000;
        ProfitMargin profitMargin = new ProfitMargin(winningAmount, purchaseAmount);
        assertThat(profitMargin.calculateMargin()).isEqualTo(EXPECTED_TEST_MARGIN);
    }

}
