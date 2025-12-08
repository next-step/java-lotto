package lotto.result;

import lotto.domain.Money;
import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LottoMatchResultTest {
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
                .isEqualTo(new Money(2_001_505_000));
    }
}
