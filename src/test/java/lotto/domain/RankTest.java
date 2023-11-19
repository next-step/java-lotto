package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class RankTest {

        @ParameterizedTest
        @EnumSource(value = Rank.class, names = {"SECOND", "THIRD"})
        void 보너스_번호_포함_여부에_따른_등수_확인(Rank rank) {
                assertThat(Rank.valueOfRank(5, true)).isEqualTo(Rank.SECOND);
                assertThat(Rank.valueOfRank(5, false)).isEqualTo(Rank.THIRD);
        }

        @ParameterizedTest
        @EnumSource(Rank.class)
        void 보너스_번호_미포함_당첨된_번호_갯수에_따른_등수_확인(Rank rank) {
                for (int i = 3; i <= 6; i++) {
                        assertThat(Rank.valueOfRank(i, false)).isNotEqualTo(Rank.MISS);
                }
                for (int i = 0; i <= 2; i++) {
                        assertThat(Rank.valueOfRank(i, false)).isEqualTo(Rank.MISS);
                }
        }
}
