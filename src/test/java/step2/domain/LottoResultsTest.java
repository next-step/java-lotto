package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또결과")
public class LottoResultsTest {

    @Test
    public void calculateWinningNumbersCount() {
        LottoResults lottoResults = new LottoResults(Arrays.asList(1, 0, 4, 3, 3, 5, 6));
        assertThat(lottoResults.calculateWinningNumbersCount(3)).isEqualTo(2);
        assertThat(lottoResults.calculateWinningNumbersCount(4)).isEqualTo(1);
        assertThat(lottoResults.calculateWinningNumbersCount(5)).isEqualTo(1);
        assertThat(lottoResults.calculateWinningNumbersCount(6)).isEqualTo(1);
    }

    @Test
    public void calculateWinnings() {
        LottoResults lottoResults = new LottoResults(Arrays.asList(1, 0, 0, 0, 0, 0, 6));
        assertThat(lottoResults.calculateTotalWinnings()).isEqualTo(2000000000);
    }

}
