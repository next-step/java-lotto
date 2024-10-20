package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TryLottoCountTest {

    public static final int EXPECTED_TRYCOUNT = 3;

    @Test
    public void convertPurchaseToLottoTryCount_테스트() {
        int purchaseAmount = 3000;
        TryLottoCount tryLottoCount = new TryLottoCount(0);
        assertThat(tryLottoCount.calculateLottoTryCount(purchaseAmount))
                .isEqualTo(EXPECTED_TRYCOUNT);
    }

}
