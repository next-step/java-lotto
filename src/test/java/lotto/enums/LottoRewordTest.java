package lotto.enums;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoRewordTest {
    @Test
    public void 로또_번호_매치() throws Exception {
        LottoReword bonusReword = LottoReword.valueOf(5, true);
        LottoReword fiveMatchReword = LottoReword.valueOf(5, false);
        LottoReword sixMatchReword = LottoReword.valueOf(6, false);
        LottoReword missMatchReword = LottoReword.valueOf(2, false);

        assertThat(bonusReword).isEqualTo(LottoReword.FIVE_AND_BONUS_MATCH);
        assertThat(fiveMatchReword).isEqualTo(LottoReword.FIVE_MATCH);
        assertThat(sixMatchReword).isEqualTo(LottoReword.SIX_MATCH);
        assertThat(missMatchReword).isEqualTo(LottoReword.MISS_MATCH);

    }

    @Test
    public void 로또_매치_금액() throws Exception {
        int reword = LottoReword.THREE_MATCH.computeReward(4);
        assertThat(reword).isEqualTo(20_000);

        reword = LottoReword.FOUR_MATCH.computeReward(5);
        assertThat(reword).isEqualTo(250_000);

        reword = LottoReword.FIVE_AND_BONUS_MATCH.computeReward(1);
        assertThat(reword).isEqualTo(30_000_000);

        reword = LottoReword.SIX_MATCH.computeReward(1);
        assertThat(reword).isEqualTo(2_000_000_000);
    }

}