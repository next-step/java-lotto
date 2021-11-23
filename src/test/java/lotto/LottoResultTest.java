package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    void rateOfProfit() {
        LottoResult result = new LottoResult(new int[]{0, 0, 0, 1, 13});
        assertThat(result.getRateOfProfit()).isEqualTo(0.35);
    }

}