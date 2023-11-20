package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeStatusTest {

    @Test
    public void assertCalculateProfit() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoFactory lottoFactory = new LottoFactory(lottoTicket);
        WinnerNumbers winnerNumbers = new WinnerNumbers(Arrays.asList(1, 2, 3, 4, 5, 7));

        PrizeStatus prizeStatus = new PrizeStatus(lottoFactory, winnerNumbers);
        double profit = prizeStatus.calculateProfit(1000);

        assertThat(profit).isEqualTo(1500000/1000);
    }
}