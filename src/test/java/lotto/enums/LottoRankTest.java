package lotto.enums;

import lotto.vo.LottoMatchResult;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {
    @Test
    public void LottoResult에서_순위_가져오기() {
        // given
        LottoMatchResult second = new LottoMatchResult(5, true);
        LottoMatchResult third = new LottoMatchResult(5, false);
        LottoMatchResult fail = new LottoMatchResult(2, true);

        // when
        LottoRank shouldBeSecond = LottoRank.getRank(second);
        LottoRank shouldBeThird = LottoRank.getRank(third);
        LottoRank shouldBeFail = LottoRank.getRank(fail);

        // then
        assertThat(shouldBeSecond).isEqualByComparingTo(LottoRank.SECOND);
        assertThat(shouldBeThird).isEqualByComparingTo(LottoRank.THIRD);
        assertThat(shouldBeFail).isEqualByComparingTo(LottoRank.FAIL);
    }
}
