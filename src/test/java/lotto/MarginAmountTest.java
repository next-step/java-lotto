package lotto;

import lotto.domain.MarginAmount;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MarginAmountTest {


    @Test
    public void 당첨금액_테스트() {
        final int TEST_RESULT_MARGIN_AMOUNT = 50000;
        final int TEST_PURCHASE_AMOUNT = 5000;
        final int TEST_MARGIN_PERCENT = 10;

        int resultMarginAmount = TEST_RESULT_MARGIN_AMOUNT;
        MarginAmount marginAmount = new MarginAmount(resultMarginAmount);
        int purchaseAmount = TEST_PURCHASE_AMOUNT;
        double marginPercent = TEST_MARGIN_PERCENT;
        assertThat(marginAmount.calculateMarginPercent(purchaseAmount)).isEqualTo(marginPercent);

    }
}
