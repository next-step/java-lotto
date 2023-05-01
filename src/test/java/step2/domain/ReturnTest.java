package step2.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.*;

public class ReturnTest {

    @ParameterizedTest
    @EnumSource(LottoResult.class)
    public void getReturnTest(LottoResult lottoResult) {
        int purchasePrice = 10000;
        Return returnCalculator = new Return(purchasePrice);
        returnCalculator.plusResult(lottoResult, 1);
        assertThat(returnCalculator.getRateOfReturn()).isEqualTo((double) lottoResult.winningPrice / purchasePrice);
    }

}
