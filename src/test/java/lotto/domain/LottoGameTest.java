package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("로또 게임 테스트")
class LottoGameTest {

    @DisplayName("잘못된 로또 티켓 숫자가 전달되면 LottoGame 객체 생성에 실패한다")
    @Test
    void createLottoGame_withInvalidTicketCount() {
        int numberOfTickets = -5;
        String winningNumbersString = "1, 2, 3, 4, 5, 6";

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() ->
                        new LottoGame(new LottoGenerator().generateLottoTickets(numberOfTickets), winningNumbersString))
                .withMessage("로또 티켓은 1장 보다 적게 생성 할 수 없습니다");
    }

    @DisplayName("잘못된 당첨 로또 문자열이 전달되면 LottoGame 객체 생성에 실패한다")
    @Test
    void createLottoGame_withInvalidWinningInput() {
        int numberOfTickets = 2;
        String winningNumbersString = "1, 2, 3, 4, 5";

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() ->
                        new LottoGame(new LottoGenerator().generateLottoTickets(numberOfTickets), winningNumbersString))
                .withMessage("로또는 6개의 번호로 이루어져야 합니다");
    }


    @DisplayName("로또 게임 객체 생성에 성공하면 더 이상 빈값이 아니다")
    @Test
    void createLottoGame() {
        int numberOfTickets = 5;
        LottoTickets lottoTickets = new LottoGenerator().generateLottoTickets(numberOfTickets);
        String winningNumbersString = "1, 2, 3, 4, 5, 6";

        LottoGame lottoGame = new LottoGame(lottoTickets, winningNumbersString);

        assertNotNull(lottoGame, "LottoGame 객체 생성 실패");
    }

    @DisplayName("로또 게임 객체 생성에 성공하면 통계 수익률을 얻을 수 있다")
    @Test
    void calculateWinningStatistics() {
        int numberOfTickets = 5;
        LottoTickets lottoTickets = new LottoGenerator().generateLottoTickets(numberOfTickets);
        String winningNumbersString = "1, 2, 3, 4, 5, 6";
        LottoGame lottoGame = new LottoGame(lottoTickets, winningNumbersString);

        WinningStatistics winningStatistics = lottoGame.calculateWinningStatistics();

        assertNotNull(winningStatistics, "당첨 통계 계산 실패");
        assertTrue(winningStatistics.calculateEarningsRate(numberOfTickets) >= 0, "수익률 계산이 올바르지 않음");
    }
}
