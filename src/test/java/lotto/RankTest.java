package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RankTest {
    @Test
    void match() {
        Assertions.assertThat(Rank.valueOf(6,false)).isEqualTo(Rank.FIRST);
        Assertions.assertThat(Rank.valueOf(5,true)).isEqualTo(Rank.SECOND);
        Assertions.assertThat(Rank.valueOf(5,false)).isEqualTo(Rank.THIRD);
        Assertions.assertThat(Rank.valueOf(4,true)).isEqualTo(Rank.FOURTH);
        Assertions.assertThat(Rank.valueOf(4,false)).isEqualTo(Rank.FOURTH);
        Assertions.assertThat(Rank.valueOf(3,false)).isEqualTo(Rank.FIFTH);
        Assertions.assertThat(Rank.valueOf(2,false)).isEqualTo(Rank.MISS);
    }
}
