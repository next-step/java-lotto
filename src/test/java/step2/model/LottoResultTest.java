package step2.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @Test
    public void 로또_당첨_결과에_따른_수익_계산하기() {
        Money money = new Money(4500);
        LottoResult lottoResult = new LottoResult(new EnumMap<>(Map.of(
                LottoRank.FIRST_PRIZE, 1L,
                LottoRank.SECOND_PRIZE, 1L,
                LottoRank.FIFTH_PRIZE, 1L,
                LottoRank.NO_PRIZE, 0L)));

        double expected = (LottoRank.FIRST_PRIZE.getPrizeMoney() + LottoRank.SECOND_PRIZE.getPrizeMoney()
                +LottoRank.FIFTH_PRIZE.getPrizeMoney() + LottoRank.NO_PRIZE.getPrizeMoney()) / (double) 4000 ;

        assertThat(lottoResult.calculateProfitRate(money.determineLottoPurchaseCount()))
                .isEqualTo(expected);
    }
}
