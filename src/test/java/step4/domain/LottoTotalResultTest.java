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
        int numberOfMatched = rank.equals(Rank.SECOND) ? rank.numbersToBeMatched - 1 : rank.numbersToBeMatched;
        lottosTotalResult.plusOne(numberOfMatched, rank.equals(Rank.SECOND));
        assertThat(lottosTotalResult.getRateOfReturn(purchasePrice)).isEqualTo((double) rank.winningPrice / purchasePrice);
    }

}
