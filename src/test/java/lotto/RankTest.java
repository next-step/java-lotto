package lotto;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    @DisplayName("몇 개 맞았는지 확인해서 순위 가져오기")
    public void getRank() {
        assertThat(Rank.getRank(2)).isEqualTo(Rank.NOTHING);
        assertThat(Rank.getRank(3)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.getRank(4)).isEqualTo(Rank.THIRD);
        assertThat(Rank.getRank(5)).isEqualTo(Rank.SECOND);
        assertThat(Rank.getRank(6)).isEqualTo(Rank.FIRST);
    }

}
