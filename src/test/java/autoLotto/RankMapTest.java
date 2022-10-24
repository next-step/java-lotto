package autoLotto;

import org.junit.jupiter.api.Test;

import static autoLotto.Rank.*;
import static org.assertj.core.api.Assertions.*;

public class RankMapTest {
    @Test
    void count() {
        RankMap.count(FIRST);
        assertThat(RankMap.getRankMap().get(FIRST)).isEqualTo(1);
    }
}
