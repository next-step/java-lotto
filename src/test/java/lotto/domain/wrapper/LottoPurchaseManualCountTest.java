package lotto.domain.wrapper;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoPurchaseManualCountTest {

    @Test
    void 수동구매_개수_Test() {
        LottoPurchase lottoPurchase = new LottoPurchase(5000, 2);
        assertThat(lottoPurchase.manualCount()).isEqualTo(2);
    }

    @Test
    void 수동구매_개수에_따른_자동구매_개수_Test() {
        LottoPurchase lottoPurchase = new LottoPurchase(5000, 2);
        assertThat(lottoPurchase.countOfAvailableAutoLotto()).isEqualTo(3);
    }

}
