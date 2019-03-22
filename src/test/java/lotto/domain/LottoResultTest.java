package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @Test
    public void 결과에따른수익률() {
        String money = "14000";
        int totalPrize = 10000;
        LottoResult lottoResult = new LottoResult(new Purchase(money), totalPrize);
        double result = lottoResult.earningsRate();
        assertThat(result).isEqualTo(0.71);

    }
}