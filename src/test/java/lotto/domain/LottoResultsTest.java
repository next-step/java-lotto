package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultsTest {

    @Test
    @DisplayName("당첨 결과를 바탕으로 당첨 금액을 계산한다.")
    void sumPrice() {
        LottoResults lottoResults = new LottoResults();
        lottoResults.add(LottoRank.FIRST, 1);
        Money price = lottoResults.sumPrize();
        Assertions.assertThat(price).isEqualTo(new Money(2_000_000_000L));
    }
}
