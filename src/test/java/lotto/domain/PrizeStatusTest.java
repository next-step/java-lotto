package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeStatusTest {

    @Test
    public void assertCalculateProfit() {
        List<Integer> lottoNumbersForTicket = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumbersForWinnerNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);

        LottoTicket lottoTicket = new LottoTicket(lottoNumbersForTicket);
        LottoFactory lottoFactory = new LottoFactory(lottoTicket);
        WinnerNumbers winnerNumbers = new WinnerNumbers(lottoNumbersForWinnerNumbers);

        PrizeStatus prizeStatus = new PrizeStatus(lottoFactory, winnerNumbers);
        double profit = prizeStatus.calculateProfit(1000);

        assertThat(profit).isEqualTo(1500000/1000);
    }
}