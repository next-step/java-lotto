package lotto.enums;

import lotto.vo.LottoResult;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {
    @Test
    public void LottoResult에서_순위_가져오기() {
        // given
        LottoResult second = new LottoResult(5, true);
        LottoResult third = new LottoResult(5, false);
        LottoResult fail = new LottoResult(2, true);

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
