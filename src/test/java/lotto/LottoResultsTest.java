package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultsTest {

    @Test
    @DisplayName("당첨 금액 계산 테스트")
    void sumPrice() {
        LottoResults lottoResults = new LottoResults();
        lottoResults.add(LottoRank.FIRST, 1);
        long price = lottoResults.sumPrice();
        Assertions.assertThat(price).isEqualTo(2_000_000_000L);
    }
}