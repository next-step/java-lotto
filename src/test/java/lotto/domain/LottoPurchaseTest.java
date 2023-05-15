package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class LottoPurchaseTest {

    @Test
    public void autoAmount() {
        LottoPurchase lottoPurchase = new LottoPurchase("14000", "0");
        assertThat(lottoPurchase.autoStream().count()).isEqualTo(14);
    }

    @Test
    public void manualAmount() {
        LottoPurchase lottoPurchase = new LottoPurchase("14000", "2");
        assertThat(lottoPurchase.manualStream().count()).isEqualTo(2);
    }
}
