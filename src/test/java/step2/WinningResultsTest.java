package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultsTest {

    @Test
    @DisplayName("당첨 번호를 저장한다.")
    void winning_numbers_save_test() {
        WinningResults winningResults = new WinningResults();
        Ticket winningNumbers = new Ticket();
        winningNumbers.saveLottoNumbers(Arrays.asList(1, 2, 3, 4, 5));

        winningResults.saveWinningLottoNumber(winningNumbers);

        Ticket getWinningNumbers = winningResults.getWinningLottoNumber();

        assertThat(getWinningNumbers).isEqualTo(winningNumbers);
    }
}
