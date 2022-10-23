package lotto.domain.rank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RankMapTest {

    @Test
    void create() {
        Assertions.assertAll(
                () -> assertThat(new RankMap(Rank.values())).isEqualTo(new RankMap(Rank.values()))
        );
    }
}
