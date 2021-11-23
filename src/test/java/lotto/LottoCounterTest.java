package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCounterTest {

    private final LottoCounter lottoCounter = new LottoCounter();

    @ParameterizedTest
    @CsvSource(value = {"6,1,0,0,0", "5,0,1,0,0", "4,0,0,1,0", "3,0,0,0,1"})
    public void count(int matchCount, int firstPlaceCount, int secondPlaceCount, int thirdPlaceCount, int fourthPlaceCount) {
        lottoCounter.countResult(matchCount);
        LottoResult result = lottoCounter.makeResult();

        assertThat(result.getFirstPlaceCount()).isEqualTo(firstPlaceCount);
        assertThat(result.getSecondPlaceCount()).isEqualTo(secondPlaceCount);
        assertThat(result.getThirdPlaceCount()).isEqualTo(thirdPlaceCount);
        assertThat(result.getFourthPlaceCount()).isEqualTo(fourthPlaceCount);
    }

}
