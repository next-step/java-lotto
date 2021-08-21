package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

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


    @Test
    @DisplayName("구매한 티켓의 당첨 결과를 확인한다.")
    void check_winning_results_test() {

        Ticket lottoNumbers1 = new Ticket();
        lottoNumbers1.saveLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));

        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.addLottoTicket(lottoNumbers1);

        WinningResults winningResults = new WinningResults();
        Ticket winningNumbers = new Ticket();
        winningNumbers.saveLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        winningResults.saveWinningLottoNumber(winningNumbers);

        winningResults.checkWinning(lottoTickets);

        Map<Award, Integer> winningResult = winningResults.getWinningResult();

        assertThat(winningResult.get(Award.FIRST)).isEqualTo(1);
    }
}
