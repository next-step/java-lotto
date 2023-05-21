package step4.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import step4.domain.LottosTotalResult;
import step4.domain.Rank;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTotalResultTest {

    @ParameterizedTest
    @EnumSource(Rank.class)
    public void getReturnTest(Rank rank) {
        int purchasePrice = 10000;
        LottosTotalResult lottosTotalResult = new LottosTotalResult();
        lottosTotalResult.plusOne(rank.numbersToBeMatched, rank.equals(Rank.SECOND));
        assertThat(lottosTotalResult.getRateOfReturn(purchasePrice)).isEqualTo((double) rank.winningPrice / purchasePrice);
    }

}
