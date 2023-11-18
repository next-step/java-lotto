package step2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @Test
    public void 로또_당첨_결과에_따른_총_상금_계산하기() {
        LottoResult lottoResult = new LottoResult(LottoRank.FIRST_PRIZE, LottoRank.SECOND_PRIZE,
                LottoRank.FOURTH_PRIZE, LottoRank.NO_PRIZE);

        assertThat(lottoResult.calculateTotalPrizeMoney()).isEqualTo(LottoRank.NO_PRIZE.getPrizeMoney());
    }
}
