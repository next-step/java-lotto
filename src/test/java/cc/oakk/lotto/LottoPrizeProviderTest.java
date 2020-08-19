package cc.oakk.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoPrizeProviderTest {
    @Test
    public void getPrizeByRank() {
        assertThat(LottoPrizeProvider.getPrizeByRank(Rank.FIRST)).isEqualTo(2000000000L);
        assertThat(LottoPrizeProvider.getPrizeByRank(Rank.SECOND)).isEqualTo(1500000L);
        assertThat(LottoPrizeProvider.getPrizeByRank(Rank.THIRD)).isEqualTo(50000L);
        assertThat(LottoPrizeProvider.getPrizeByRank(Rank.FOURTH)).isEqualTo(5000L);
        assertThat(LottoPrizeProvider.getPrizeByRank(Rank.FIFTH)).isEqualTo(0L);
        assertThat(LottoPrizeProvider.getPrizeByRank(Rank.NONE)).isEqualTo(0L);

        assertThatIllegalArgumentException().isThrownBy(() -> LottoPrizeProvider.getPrizeByRank(null));
    }
}
