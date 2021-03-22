package lotto;

import lotto.domain.Winning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningTest {

    @ParameterizedTest
    @CsvSource(value = {"3,4:55000", "3,5:1505000"}, delimiter = ':')
    @DisplayName("당첨된 금액의 총 합을 구할 수 있다.")
    void canSumWinningAmount(String input, int totalAmount) {
        String[] countMatchNumber = input.split(",");

        Winning winning = new Winning();
        winning.record(Integer.parseInt(countMatchNumber[0]), false);
        winning.record(Integer.parseInt(countMatchNumber[1]), false);

        assertThat(winning.getSumAmount()).isEqualTo(totalAmount);
    }
}
