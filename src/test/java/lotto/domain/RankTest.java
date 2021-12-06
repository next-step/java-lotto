package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    void 일치하는_로또넘버_개수_test() {

        Rank rank = Rank.valueOf(5, true);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }
}
