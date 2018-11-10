package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPrizeTest {

    @Test
    public void 이등_당첨_검증() {
        assertThat(LottoPrize.findPrize(5, 1)).isEqualTo(LottoPrize.SECOND);
    }

    @Test
    public void 삼등_당첨_검증() {
        assertThat(LottoPrize.findPrize(5, 0)).isEqualTo(LottoPrize.THIRD);
    }
}