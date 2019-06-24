package step2.iksoo.lottoAuto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPrizeTest {
    @Test
    void 로또_1등_20억() {
        LottoPrize lottoPrize = LottoPrize.six;
        assertThat(lottoPrize.getGradePrize()).isEqualTo(2000000000);
    }
}
