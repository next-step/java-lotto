package lotto;

import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RankTest {
    @Test
    void converterPrize() {
        // GIVE
        Rank rank = Rank.converterPrize(6);
        // WHEN
        // THAN
        assertThat(rank).isEqualTo(Rank.FIRST);

    }

    @Test
    void converterPrizeException() {
        // GIVE
        // WHEN
        // THAN
        assertThatThrownBy(() -> Rank.converterPrize(8))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
