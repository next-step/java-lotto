package lotto;

import lotto.game.Rank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @Test
    void rankMatchNumberCount() {
        assertThat(Rank.FIRST_WIN.count).isEqualTo(6);
        assertThat(Rank.SECOND_WIN.count).isEqualTo(5);
        assertThat(Rank.THIRD_WIN.count).isEqualTo(4);
        assertThat(Rank.FORTH_WIN.count).isEqualTo(3);
        assertThat(Rank.LOSE.count).isEqualTo(2);
    }

    @Test
    void rankAward() {
        assertThat(Rank.FIRST_WIN.award).isEqualTo(2000000000);
        assertThat(Rank.SECOND_WIN.award).isEqualTo(1500000);
        assertThat(Rank.THIRD_WIN.award).isEqualTo(50000);
        assertThat(Rank.FORTH_WIN.award).isEqualTo(5000);
        assertThat(Rank.LOSE.award).isEqualTo(0);
    }

    @Test
    void of() {
        assertThat(Rank.of(6)).isEqualTo(Rank.FIRST_WIN);
        assertThat(Rank.of(5)).isEqualTo(Rank.SECOND_WIN);
        assertThat(Rank.of(4)).isEqualTo(Rank.THIRD_WIN);
        assertThat(Rank.of(3)).isEqualTo(Rank.FORTH_WIN);
        assertThat(Rank.of(2)).isEqualTo(Rank.LOSE);
        assertThat(Rank.of(1)).isEqualTo(Rank.LOSE);
        assertThat(Rank.of(0)).isEqualTo(Rank.LOSE);
    }
}