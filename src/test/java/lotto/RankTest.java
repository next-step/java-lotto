package lotto;

import lotto.domain.Rank;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class RankTest {

    @Test
    public void enum_name_테스트() {
        assertThat(Rank.valueOf(Rank.FOURTH.name())).isEqualTo(Rank.FOURTH);
    }
    @Test
    public void 일등() {
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
    }

    @Test
    public void 이등() {
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
    }

    @Test
    public void 그외() {
        assertThat(Rank.valueOf(2, false)).isEqualTo(Rank.MISS);
    }

}