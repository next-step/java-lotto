package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    void rank() {
        assertThat(Rank.valueOfRank(6,true)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOfRank(5,true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOfRank(5,false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOfRank(4, true)).isEqualTo(Rank.FOUR);
        assertThat(Rank.valueOfRank(3, true)).isEqualTo(Rank.FIVE);
        assertThat(Rank.valueOfRank(7, false)).isEqualTo(Rank.NOTHING);
    }

    @Test
    void rankMoney() {
        assertThat(Rank.valueOfRank(6, false).getMoney()).isEqualTo(2000000000);
    }
}
