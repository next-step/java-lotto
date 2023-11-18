package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PrizeTest {

    @DisplayName("개수에 맞는 상금을 반환")
    @CsvSource(value = {"3,5000", "4,50000", "5,1500000", "6,2000000000"})
    @ParameterizedTest(name = "{0} 개 일치시 {1}")
    void prizeByRank(int rank, int expectedPrize) {
        int actualPrize = Prize.prizeByRank(rank);
        Assertions.assertThat(actualPrize).isEqualTo(expectedPrize);
    }

}
