package step3.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTotalResultTest {

    @ParameterizedTest
    @EnumSource(step3.domain.LottoResult.class)
    public void getReturnTest(LottoResult lottoResult) {
        int purchasePrice = 10000;
        step3.domain.LottosTotalResult lottosTotalResult = new LottosTotalResult();
        lottosTotalResult.plusOne(lottoResult.numbersToBeMatched);
        assertThat(lottosTotalResult.getRateOfReturn(purchasePrice)).isEqualTo((double) lottoResult.winningPrice / purchasePrice);
    }

}
