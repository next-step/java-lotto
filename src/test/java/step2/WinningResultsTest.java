package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultsTest {

    @Test
    @DisplayName("당첨 번호를 저장한다.")
    void winning_numbers_save_test() {
        WinningResults winningResults = new WinningResults();
        LottoTicket winningNumbers = new LottoTicket();
        winningNumbers.saveLottoNumbers(Arrays.asList(1, 2, 3, 4, 5));

        winningResults.saveWinningLottoNumber(winningNumbers);

        LottoTicket getWinningNumbers = winningResults.getWinningLottoNumber();

        assertThat(getWinningNumbers).isEqualTo(winningNumbers);
    }
}
