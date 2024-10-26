package deprecatedlotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TryLottoCountTest {

    public static final int EXPECTED_TRYCOUNT = 3;
    public static final int TEST_PURCHASE_AMOUNT = 3000;

    @Test
    public void convertPurchaseToLottoTryCount_테스트() {
        int purchaseAmount = TEST_PURCHASE_AMOUNT;
        TryLottoCount tryLottoCount = new TryLottoCount(0, purchaseAmount);
        assertThat(tryLottoCount.calculateLottoTryCount())
                .isEqualTo(EXPECTED_TRYCOUNT);
    }

}
