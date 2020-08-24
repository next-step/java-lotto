package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("당첨금")
public class WinningsTest {

    @ParameterizedTest
    @CsvSource(value = { "3,5000", "4,50000", "5,1500000", "6,2000000000" })
    public void calculateWinnings(int winningNumbersCount, int winnings) {
        assertThat(Winnings.calculateWinnings(winningNumbersCount)).isEqualTo(winnings);
    }

}
