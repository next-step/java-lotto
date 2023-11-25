package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeStatusTest {

    @Test
    public void assertCalculateProfit() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoFactory lottoFactory = new LottoFactory(lottoTicket);
        WinnerNumbers winnerNumbers = new WinnerNumbers(Arrays.asList(1, 2, 3, 4, 5, 7), 10);

        PrizeStatus prizeStatus = new PrizeStatus(lottoFactory, winnerNumbers);
        double profit = prizeStatus.calculateProfit(1000);

        assertThat(profit).isEqualTo(1500000/1000);
    }

    @Test
    public void assertBonusWinnerProfit() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoFactory lottoFactory = new LottoFactory(lottoTicket);
        WinnerNumbers winnerNumbers = new WinnerNumbers(Arrays.asList(1, 2, 3, 4, 5, 7), 1);

        PrizeStatus prizeStatus = new PrizeStatus(lottoFactory, winnerNumbers);
        double profit = prizeStatus.calculateProfit(1000);

        assertThat(profit).isEqualTo(3000000/1000);
    }
}