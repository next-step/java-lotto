package lottery.domain;

import lottery.dto.RoundResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lottery.domain.Prize.*;
import static org.assertj.core.api.Assertions.assertThat;

class LotteryTicketTest {

    private LotteryTicket lotteryTicket;
    private WinningLottery winningLottery;

    @BeforeEach
    void init() {
        LotteryNumbers losingLottery = new LotteryNumbers(Arrays.asList(1, 2, 7, 8, 9, 10));
        LotteryNumbers fifthPlaceLottery = new LotteryNumbers(Arrays.asList(1, 2, 3, 7, 8, 9));
        LotteryNumbers thirdPlaceLottery = new LotteryNumbers(Arrays.asList(1, 2, 3, 4, 5, 9));
        LotteryNumbers secondPlaceLottery = new LotteryNumbers(Arrays.asList(1, 2, 3, 4, 5, 7));

        List<LotteryNumbers> lotteries = Arrays.asList(losingLottery, losingLottery,
            losingLottery, fifthPlaceLottery, fifthPlaceLottery, thirdPlaceLottery, secondPlaceLottery);

        lotteryTicket = new LotteryTicket(lotteries);

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LotteryNumber bonusNumber = new LotteryNumber(7);

        winningLottery = new WinningLottery(new LotteryNumbers(winningNumbers), bonusNumber);
    }

    @Test
    @DisplayName("당첨 번호와 대조하여 결과를 생성한다.")
    void getResultFromWinningNumbers() {
        RoundResult roundResult = lotteryTicket.getResult(winningLottery);

        assertThat(roundResult.getPrizes())
            .containsExactly(LOSING_TICKET, LOSING_TICKET, LOSING_TICKET, FIFTH, FIFTH, THIRD, SECOND);
    }

    @Test
    @DisplayName("생성된 결과에서 수익률을 가져온다.")
    void getRateOfReturn() {
        long total = FIFTH.getWinnings() * 2 + THIRD.getWinnings() + SECOND.getWinnings();
        double expectedRateOfReturn = total / (1000.0 * lotteryTicket.exportLotteryNumbers().size());

        RoundResult roundResult = lotteryTicket.getResult(winningLottery);

        assertThat(roundResult.getRateOfReturn()).isEqualTo(expectedRateOfReturn);
    }
}
