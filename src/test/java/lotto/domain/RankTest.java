package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    void rank1등() {
        assertThat(Rank.rank(6, true)).isEqualTo(Rank.FIRST);
        assertThat(Rank.rank(6, false)).isEqualTo(Rank.FIRST);
    }

    @Test
    void rank2등() {
        assertThat(Rank.rank(5, true)).isEqualTo(Rank.SECOND);
    }

    @Test
    void rank3등() {
        assertThat(Rank.rank(5, false)).isEqualTo(Rank.THIRD);
    }

    @Test
    void rank4등() {
        assertThat(Rank.rank(4, true)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.rank(4, false)).isEqualTo(Rank.FOURTH);
    }

    @Test
    void rank5등() {
        assertThat(Rank.rank(3, true)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.rank(3, false)).isEqualTo(Rank.FIFTH);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void rank_미당첨(int input) {
        assertThat(Rank.rank(input, false)).isEqualTo(Rank.DEFAULT);
    }

    @Test
    void multiply_TEST() {
        Amount result = Rank.THIRD.multiply(Amount.of(2));
        assertThat(result).isEqualTo(new Amount(3_000_000));
    }
}
