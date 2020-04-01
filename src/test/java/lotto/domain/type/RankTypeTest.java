package lotto.domain.type;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTypeTest {
    @Test
    void getRank() {
        assertThat(RankType.getRank(1, true)).isEqualTo(RankType.NO_RANK);
        assertThat(RankType.getRank(3, true)).isEqualTo(RankType.RANK5);
        assertThat(RankType.getRank(4, true)).isEqualTo(RankType.RANK4);
        assertThat(RankType.getRank(5, false)).isEqualTo(RankType.RANK3);
        assertThat(RankType.getRank(5, true)).isEqualTo(RankType.RANK2);
        assertThat(RankType.getRank(6, true)).isEqualTo(RankType.RANK1);
        assertThat(RankType.getRank(7, true)).isEqualTo(RankType.NO_RANK);
    }
}
