package lotto;

import lotto.domain.Rank;
import lotto.domain.Result;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    void rankAddCount() {
        Result result = new Result();
        result.put(Rank.FIFTH);

        int fifthCount = result.countRank(Rank.FIFTH);
        int firstCount = result.countRank(Rank.FIRST);

        assertThat(fifthCount).isEqualTo(1);
        assertThat(firstCount).isEqualTo(0);
    }
}