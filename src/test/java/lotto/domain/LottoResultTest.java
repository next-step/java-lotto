package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @ParameterizedTest
    @CsvSource(value = {
            "10000, FOURTH, 0.5",
            "10000, THIRD, 5"
    })
    @DisplayName("로또 수익률")
    void testGetYield(int purchaseAmount, String ranking, double yield) {
        // given
        LottoResult result = new LottoResult(purchaseAmount);
        // when
        result.addRanking(LottoRanking.valueOf(ranking));
        // then
        assertThat(result.getYield()).isEqualTo(yield);
    }
}
