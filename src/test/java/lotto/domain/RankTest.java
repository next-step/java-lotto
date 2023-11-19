package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class RankTest {

        @ParameterizedTest
        @EnumSource(Rank.class)
        void 당첨된_번호_갯수에_따른_등수_확인(Rank rank) {
                for (int i = 3; i <= 6; i++) {
                        assertThat(Rank.valueOfRank(i)).isNotEqualTo(Rank.MISS);
                }
                for (int i = 0; i <= 2; i++) {
                        assertThat(Rank.valueOfRank(i)).isEqualTo(Rank.MISS);
                }
        }
}
