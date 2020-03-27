package type;

import lotto.type.RankType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTypeTest {
    @Test
    void getRank() {
        assertThat(RankType.getRank(1)).isEqualTo(RankType.NO_RANK);
        assertThat(RankType.getRank(3)).isEqualTo(RankType.RANK4);
        assertThat(RankType.getRank(4)).isEqualTo(RankType.RANK3);
        assertThat(RankType.getRank(5)).isEqualTo(RankType.RANK2);
        assertThat(RankType.getRank(6)).isEqualTo(RankType.RANK1);
        assertThat(RankType.getRank(7)).isEqualTo(RankType.RANK1);
    }
}
