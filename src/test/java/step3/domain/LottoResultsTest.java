package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.LottoResults;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또결과")
public class LottoResultsTest {

    @Test
    public void calculateWinningNumbersCount() {
        LottoResults lottoResults = new LottoResults(Arrays.asList(Rank.MISS, Rank.MISS, Rank.MISS, Rank.FIRST, Rank.MISS, Rank.SECOND, Rank.MISS));
        assertThat(lottoResults.calculateWinningNumbersCount(Rank.FIRST)).isEqualTo(1);
        assertThat(lottoResults.calculateWinningNumbersCount(Rank.SECOND)).isEqualTo(1);
    }

    @Test
    public void calculateWinnings() {
        LottoResults lottoResults = new LottoResults(Arrays.asList(Rank.MISS, Rank.MISS, Rank.MISS, Rank.FIRST, Rank.MISS, Rank.SECOND, Rank.MISS));
        assertThat(lottoResults.calculateTotalWinnings()).isEqualTo(2_030_000_000);
    }

}
