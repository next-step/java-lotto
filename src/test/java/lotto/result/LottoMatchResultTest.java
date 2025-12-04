package lotto.result;

import static org.assertj.core.api.Assertions.*;

import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

class LottoMatchResultTest {

    @Test
    void create() {
        assertThatCode(() -> new LottoMatchResult(Rank.FIRST, Rank.FOURTH)).doesNotThrowAnyException();
    }

    @Test
    void totalPrize() {
        LottoMatchResult result = new LottoMatchResult(Rank.FIRST, Rank.FIFTH);
        result.updateRank(Rank.THIRD);
        System.out.println(result);
        assertThat(result.totalPrize())
                .isEqualTo(2_001_505_000);
    }
}