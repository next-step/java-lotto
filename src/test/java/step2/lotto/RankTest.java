package step2.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RankTest {

    @Test
    void 일치하는_개수를_통해_등급을_구할_수_있다() {
        assertThat(Rank.rank(6)).isEqualTo(Rank.FIRST);
    }

    @Test
    void 꽝이_아닐_경우_참을_반환한다() {
        assertTrue(Rank.FIRST.isNotNothing());
    }
}
