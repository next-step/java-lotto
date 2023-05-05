package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("당첨 순위 테스트")
class WinningRankTest {

    @DisplayName("당첨 번호 일치 개수에 따라 로또 등수를 반환한다")
    @Test
    void valueOf() {
        assertThat(WinningRank.FIRST).isEqualTo(WinningRank.valueOf(6));
        assertThat(WinningRank.FOURTH).isEqualTo(WinningRank.valueOf(4));
        assertThat(WinningRank.FIFTH).isEqualTo(WinningRank.valueOf(3));
        assertThat(WinningRank.NONE).isEqualTo(WinningRank.valueOf(2));
        assertThat(WinningRank.NONE).isEqualTo(WinningRank.valueOf(1));
        assertThat(WinningRank.NONE).isEqualTo(WinningRank.valueOf(0));
    }

    @DisplayName("당첨 번호가 5개 일치할때 보너스 번호 일치여부에 따라 로또 등수가 2,3등으로 나뉜다")
    @Test
    void ValueOfWithBonusNumber() {
        assertThat(WinningRank.valueOf(5, true)).isEqualTo(WinningRank.SECOND);
        assertThat(WinningRank.valueOf(5, false)).isEqualTo(WinningRank.THIRD);
    }

    @DisplayName("당첨 등수는 5등까지 분류된다")
    @Test
    void validRanks() {
        List<WinningRank> expected = List.of(
                WinningRank.FIFTH,
                WinningRank.FOURTH,
                WinningRank.THIRD,
                WinningRank.SECOND,
                WinningRank.FIRST
        );

        List<WinningRank> actual = WinningRank.validRanks();

        assertThat(expected).isEqualTo(actual);
    }
}