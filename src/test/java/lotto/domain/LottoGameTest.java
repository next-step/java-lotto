package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("로또 게임 테스트")
class LottoGameTest {

    @DisplayName("당첨 생성 티켓 숫자가 잘못되면 LottoGame 객체 생성에 실패한다 ")
    @Test
    void createLottoGame_withInvalidTicketCount() {
        // Given
        int numberOfTickets = -5;
        String winningNumbersString = "1, 2, 3, 4, 5, 6";

        // When
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() ->
                        new LottoGame(new LottoGenerator().generateLottoTickets(numberOfTickets), winningNumbersString))
                .withMessage("로또 티켓은 1장 보다 적게 생성 할 수 없습니다");
    }

    @DisplayName("당첨 숫자 입력이 잘못되면 LottoGame 객체 생성에 실패한다 ")
    @Test
    void createLottoGame_withInvalidWinningInput() {
        // Given
        int numberOfTickets = 2;
        String winningNumbersString = "1, 2, 3, 4, 5";

        // When
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() ->
                        new LottoGame(new LottoGenerator().generateLottoTickets(numberOfTickets), winningNumbersString))
                .withMessage("로또는 6개의 번호로 이루어져야 합니다");
    }


    @DisplayName("로또 게임 객체 생성에 성공하면 더 이상 빈값이 아니다")
    @Test
    void createLottoGame() {
        // Given
        int numberOfTickets = 5;
        LottoTickets lottoTickets = new LottoGenerator().generateLottoTickets(numberOfTickets);
        String winningNumbersString = "1, 2, 3, 4, 5, 6";

        // When
        LottoGame lottoGame = new LottoGame(lottoTickets, winningNumbersString);

        // Then
        assertNotNull(lottoGame, "LottoGame 객체 생성 실패");
    }

    @DisplayName("로또 게임 객체 생성에 성공하면 통계 수익률을 얻을 수 있다")
    @Test
    void calculateWinningStatistics() {
        // Given
        int numberOfTickets = 5;
        LottoTickets lottoTickets = new LottoGenerator().generateLottoTickets(numberOfTickets);
        String winningNumbersString = "1, 2, 3, 4, 5, 6";
        LottoGame lottoGame = new LottoGame(lottoTickets, winningNumbersString);

        // When
        WinningStatistics winningStatistics = lottoGame.calculateWinningStatistics();

        // Then
        assertNotNull(winningStatistics, "당첨 통계 계산 실패");
        assertTrue(winningStatistics.calculateEarningsRate(numberOfTickets) >= 0, "수익률 계산이 올바르지 않음");
    }
}