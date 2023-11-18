package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PrizeStatusTest {

    @Test
    public void test1() {
        List<Integer> lottoNumbersForTicket = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumbersForWinnerNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);

        LottoTicket lottoTicket = new LottoTicket(lottoNumbersForTicket);
        LottoTickets lottoTickets = new LottoTickets(lottoTicket);
        WinnerNumbers winnerNumbers = new WinnerNumbers(lottoNumbersForWinnerNumbers);

        PrizeStatus prizeStatus = new PrizeStatus(lottoTickets, winnerNumbers);
        double profit = prizeStatus.calculateProfit(1000);

        assertThat(profit).isEqualTo(1500000/1000);
    }
}