package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RankTest {

        @Test
        void 당첨된_번호_갯수가_3일_경우_4등() {
                assertThat(Rank.valueOfRank(3)).isEqualTo(Rank.FOURTH);
        }

        @Test
        void 당첨된_번호_갯수가_3미만일_경우_MISS() {
                assertThat(Rank.valueOfRank(2)).isEqualTo(Rank.MISS);
        }
}
