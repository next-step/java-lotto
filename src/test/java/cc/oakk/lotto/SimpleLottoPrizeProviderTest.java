package cc.oakk.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class SimpleLottoPrizeProviderTest {
    @Test
    public void getPrizeByRank() {
        final LottoPrizeProvider<Long> provider = new SimpleLottoPrizeProvider();

        assertThat(provider.getPrizeByRank(Rank.FIRST)).isEqualTo(2000000000L);
        assertThat(provider.getPrizeByRank(Rank.SECOND)).isEqualTo(1500000L);
        assertThat(provider.getPrizeByRank(Rank.THIRD)).isEqualTo(50000L);
        assertThat(provider.getPrizeByRank(Rank.FOURTH)).isEqualTo(5000L);
        assertThat(provider.getPrizeByRank(Rank.FIFTH)).isEqualTo(0L);
        assertThat(provider.getPrizeByRank(Rank.NONE)).isEqualTo(0L);

        assertThatIllegalArgumentException().isThrownBy(() -> provider.getPrizeByRank(null));
    }
}
