package lotto.domain.rank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RankMapTest {

    @Test
    void create() {
        assertThat(new RankMap(Rank.values())).isEqualTo(new RankMap(Rank.values()));
    }
}
