package step2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @Test
    public void 로또_당첨_결과에_따른_수익_계산하기() {
        Money money = new Money(4500);
        LottoResult lottoResult = new LottoResult(LottoRank.FIRST_PRIZE, LottoRank.SECOND_PRIZE,
                LottoRank.FOURTH_PRIZE, LottoRank.NO_PRIZE);

        double expected = (LottoRank.FIRST_PRIZE.getPrizeMoney() + LottoRank.SECOND_PRIZE.getPrizeMoney()
                +LottoRank.FOURTH_PRIZE.getPrizeMoney() + LottoRank.NO_PRIZE.getPrizeMoney()) * 100 / 4000 ;

        assertThat(lottoResult.calculateProfitRate(money.determineLottoPurchaseCount()))
                .isEqualTo(expected);
    }
}
