package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class LottoPurchaseTest {

    @Test
    public void manualAmount() {
        LottoPurchase lottoPurchase = new LottoPurchase("14000");
        assertThat(lottoPurchase.autoStream().count()).isEqualTo(10);
    }
}
