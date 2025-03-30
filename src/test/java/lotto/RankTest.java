package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class RankTest {

    @ParameterizedTest
    @EnumSource(value = Rank.class, mode = EnumSource.Mode.EXCLUDE, names = {"SECOND"})
    @DisplayName("일치하는 번호 갯수에 따라 등수를 확인(보너스 제외)")
    void defaultRankTest(Rank expectedRank) {
        var rank = Rank.valueOf(expectedRank.getCountOfMatch(), false);
        Assertions.assertThat(rank).isEqualTo(expectedRank);
    }

    @Test
    void bonusRankTest() {
        var rank = Rank.valueOf(5, true);
        Assertions.assertThat(rank).isEqualTo(Rank.SECOND);
    }

}