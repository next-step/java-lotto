package lotto.domain.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RankTest {

    @Test
    void valueOf_first() {
        Rank first = Rank.valueOf("FIRST");
        Assertions.assertThat(first).isEqualTo(Rank.FIRST);
    }


}
