package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitRateTest {

    @Test
    @DisplayName("수익률 생성")
    public void create() throws Exception {
        ProfitRate profitRate = new ProfitRate(5_000, 14_000);
        assertThat(profitRate).isEqualTo(new ProfitRate(((double) 5_000 / 14_000)));
    }

    @Test
    @DisplayName("총 당첨 금액이 구매 금액보다 더 클 경우 참을 반환한다.")
    public void isPositive() throws Exception {
        ProfitRate profitRate = new ProfitRate(14_000, 14_000);
        assertThat(profitRate.isPositive()).isTrue();
        profitRate = new ProfitRate(13_000, 14_000);
        assertThat(profitRate.isPositive()).isFalse();
    }
}
