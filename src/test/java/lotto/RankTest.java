package lotto;

import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    void Enum_matchCount() {
        Rank miss = Rank.valueOf(2, false);
        Rank fifth = Rank.valueOf(3, false);
        Rank third = Rank.valueOf(5, false);
        Rank second = Rank.valueOf(5, true);

        assertThat(miss).isEqualTo(Rank.MISS);
        assertThat(fifth).isEqualTo(Rank.FIFTH);
        assertThat(third).isEqualTo(Rank.THIRD);
        assertThat(second).isEqualTo(Rank.SECOND);
    }
}