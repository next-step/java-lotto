package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    void rank() {
        assertThat(Rank.valueOfRank(6)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOfRank(5)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOfRank(4)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOfRank(3)).isEqualTo(Rank.FOUR);
        assertThat(Rank.valueOfRank(7)).isEqualTo(Rank.NOTHING);
    }

    @Test
    void rankMoney() {
        assertThat(Rank.valueOfRank(6).getMoney()).isEqualTo(2000000000);
    }
}
