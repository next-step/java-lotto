package lottery.domain;

import lottery.dto.RoundResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lottery.domain.Prize.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LotteryTicketTest {

    @Test
    @DisplayName("당첨 번호와 대조하여 결과를 생성한다.")
    void getResultFromWinningNumbers() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        Lottery losingLottery = new Lottery(Arrays.asList(1, 2, 7, 8, 9, 10));
        Lottery fourthPlaceLottery = new Lottery(Arrays.asList(1, 2, 3, 7, 8, 9));
        Lottery thirdPlaceLottery = new Lottery(Arrays.asList(1, 2, 3, 4, 8, 9));

        List<Lottery> lotteries = Arrays.asList(losingLottery, losingLottery,
            losingLottery, fourthPlaceLottery, fourthPlaceLottery, thirdPlaceLottery);

        LotteryTicket lotteryTicket = new LotteryTicket(lotteries);

        RoundResult roundResult = lotteryTicket.getResult(winningNumbers);

        double expectedRateOfReturn = (FOURTH.getWinnings() * 2 + THIRD.getWinnings()) / (1000.0 * lotteries.size());
            assertAll(
            () -> assertThat(roundResult.getPrizes())
                .containsExactly(LOSING_TICKET, LOSING_TICKET, LOSING_TICKET, FOURTH, FOURTH, THIRD),
            () -> assertThat(roundResult.getRateOfReturn()).isEqualTo(expectedRateOfReturn)
        );
    }
}
