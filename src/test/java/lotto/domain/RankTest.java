package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


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

    @Test
    void rank_꽝() {
        assertThatIllegalArgumentException().isThrownBy(() -> Rank.rank(2, false));
        assertThatIllegalArgumentException().isThrownBy(() -> Rank.rank(1, false));
        assertThatIllegalArgumentException().isThrownBy(() -> Rank.rank(0, false));
    }

    @Test
    void multiply_TEST() {
        Amount result = Rank.THIRD.multiply(2);
        assertThat(result).isEqualTo(new Amount(3_000_000));
    }

    @DisplayName("정답인 수가 3번 이상이라면 true를 반환한다. ")
    @Test
    void rank_TEST() {
        assertThat(Rank.isRank(3)).isTrue();
    }

    @DisplayName("정답인 수가 3번 미만이라면 false를 반환한다. ")
    @Test
    void unRank_TEST() {
        assertThat(Rank.isRank(2)).isFalse();
    }
}
