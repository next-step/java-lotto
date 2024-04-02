package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    void put() {
        Rank.putMatchResult(Rank.FIRST);
        assertThat(Rank.getMatchResult().get(Rank.FIRST)).isEqualTo(1);
    }

}
