package step2.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.*;

public class LottoTotalResultTest {

    @ParameterizedTest
    @EnumSource(LottoResult.class)
    public void getReturnTest(LottoResult lottoResult) {
        int purchasePrice = 10000;
        LottosTotalResult lottosTotalResult = new LottosTotalResult();
        lottosTotalResult.plusOne(lottoResult.numbersToBeMatched);
        assertThat(lottosTotalResult.getRateOfReturn(purchasePrice)).isEqualTo((double) lottoResult.winningPrice / purchasePrice);
    }

}
