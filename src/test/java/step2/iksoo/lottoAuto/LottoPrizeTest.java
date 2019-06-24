package step2.iksoo.lottoAuto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPrizeTest {
    @Test
    void 로또_1등_20억() {
        assertThat(LottoPrize.SIX.getGradePrize()).isEqualTo(2000000000);
    }
}
