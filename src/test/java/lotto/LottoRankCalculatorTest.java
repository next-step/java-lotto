package lotto;

import lotto.service.LottoRankCalculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoRankCalculatorTest {

    @Test
    public void 로또_등수_결정() {
        assertThat(LottoRankCalculator.determineRank(5, true)).isEqualTo(2);
        assertThat(LottoRankCalculator.determineRank(5, false)).isEqualTo(3);
        assertThat(LottoRankCalculator.determineRank(3, true)).isEqualTo(0);
        assertThat(LottoRankCalculator.determineRank(4, true)).isEqualTo(5);
    }
}
