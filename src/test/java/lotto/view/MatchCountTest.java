package lotto.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MatchCountTest {

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 0",
            "2, 0",
            "3, 5000",
            "4, 50000",
            "5, 1500000",
            "6, 2000000000",
    })
    void getWinningAmountWith(int matchCount, int winningAmount) {
        int actual = MatchCount.getWinningAmountWith(matchCount);

        assertThat(actual).isEqualTo(winningAmount);
    }
}
