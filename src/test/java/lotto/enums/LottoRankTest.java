package lotto.enums;

import lotto.vo.LottoMatchResult;
import lotto.vo.Money;
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
        LottoRank shouldBeSecond = LottoRank.getRankOf(second);
        LottoRank shouldBeThird = LottoRank.getRankOf(third);
        LottoRank shouldBeFail = LottoRank.getRankOf(fail);

        // then
        assertThat(shouldBeSecond).isEqualByComparingTo(LottoRank.SECOND);
        assertThat(shouldBeThird).isEqualByComparingTo(LottoRank.THIRD);
        assertThat(shouldBeFail).isEqualByComparingTo(LottoRank.FAIL);
    }

    @Test
    public void 해당_로또_순위의_최종_당첨_금액_가져오기() {
        // given
        LottoRank second = LottoRank.SECOND;
        long lottoRankCount = 4;

        // when
        Money realTotalPrizeMoneyOfSecond = second.getTotalPrizeMoneyOfLottoRank(4);

        // then
        Money totalPrizeMoneyOfSecond = LottoRank.SECOND.getPrizeMoney().multiply(lottoRankCount);
        assertThat(realTotalPrizeMoneyOfSecond.getAmount()).isEqualTo(totalPrizeMoneyOfSecond.getAmount());
    }
}
