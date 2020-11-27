package lotto.domain.winning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created By mand2 on 2020-11-25.
 */
class WinningRankTest {

    @Test
    @DisplayName("rank : 1등")
    void rank_first_place() {
        assertThat(WinningRank.getWinningRank(6, true)).isEqualTo(WinningRank.FIRST);
        assertThat(WinningRank.getWinningRank(6, false)).isEqualTo(WinningRank.FIRST);
    }

    @Test
    @DisplayName("rank : 2등")
    void rank_second_place() {
        assertThat(WinningRank.getWinningRank(5, true)).isEqualTo(WinningRank.SECOND);
    }

    @Test
    @DisplayName("rank : 3등")
    void rank_third_place() {
        assertThat(WinningRank.getWinningRank(5, false)).isEqualTo(WinningRank.THIRD);
    }
    @Test
    @DisplayName("rank : 4등")
    void rank_fourth_place() {
        assertThat(WinningRank.getWinningRank(4, true)).isEqualTo(WinningRank.FOURTH);
        assertThat(WinningRank.getWinningRank(4, false)).isEqualTo(WinningRank.FOURTH);
    }
    @Test
    @DisplayName("rank : 5등")
    void rank_fifth_place() {
        assertThat(WinningRank.getWinningRank(3, true)).isEqualTo(WinningRank.FIFTH);
        assertThat(WinningRank.getWinningRank(3, false)).isEqualTo(WinningRank.FIFTH);
    }
    @Test
    @DisplayName("rank : 없음")
    void rank_none_place() {
        assertThat(WinningRank.getWinningRank(1, true)).isEqualTo(WinningRank.NONE);
        assertThat(WinningRank.getWinningRank(1, false)).isEqualTo(WinningRank.NONE);
    }
}
