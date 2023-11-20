package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RankTest {

        @Test
        void 보너스_번호_포함_여부에_따른_등수_확인() {
                assertThat(Rank.valueOfRank(5, true)).isEqualTo(Rank.SECOND);
                assertThat(Rank.valueOfRank(5, false)).isEqualTo(Rank.THIRD);
        }
}
