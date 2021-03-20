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
    private List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    private int bonusNumber = 7;

    @BeforeEach
    void init() {
        Lottery losingLottery = new Lottery(Arrays.asList(1, 2, 7, 8, 9, 10));
        Lottery fifthPlaceLottery = new Lottery(Arrays.asList(1, 2, 3, 7, 8, 9));
        Lottery thirdPlaceLottery = new Lottery(Arrays.asList(1, 2, 3, 4, 5, 9));
        Lottery secondPlaceLottery = new Lottery(Arrays.asList(1, 2, 3, 4, 5, 7));

        List<Lottery> lotteries = Arrays.asList(losingLottery, losingLottery,
            losingLottery, fifthPlaceLottery, fifthPlaceLottery, thirdPlaceLottery, secondPlaceLottery);

        lotteryTicket = new LotteryTicket(lotteries);

        winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        bonusNumber = 7;
    }

    @Test
    @DisplayName("당첨 번호와 대조하여 결과를 생성한다.")
    void getResultFromWinningNumbers() {
        RoundResult roundResult = lotteryTicket.getResult(winningNumbers, bonusNumber);

        assertThat(roundResult.getPrizes())
            .containsExactly(LOSING_TICKET, LOSING_TICKET, LOSING_TICKET, FIFTH, FIFTH, THIRD, SECOND);
    }

    @Test
    @DisplayName("생성된 결과에서 수익률을 가져온다.")
    void getRateOfReturn() {
        long total = FIFTH.getWinnings() * 2 + THIRD.getWinnings() + SECOND.getWinnings();
        double expectedRateOfReturn = total / (1000.0 * lotteryTicket.getLotteries().size());

        RoundResult roundResult = lotteryTicket.getResult(winningNumbers, bonusNumber);

        assertThat(roundResult.getRateOfReturn()).isEqualTo(expectedRateOfReturn);
    }
}
