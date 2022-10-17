package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RankTest {

    @Test
    void create() {
        Rank rank = new Rank(1);

        assertThat(rank).isEqualTo(new Rank(1));
    }
}
