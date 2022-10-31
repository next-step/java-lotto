package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

public class LottoWinnerStatTest {
    @Test
    void test_get_profit_margin() {
        int totalTicketCount = 10;
        List<LottoWinner> winners = List.of(
                new LottoWinner(3, LottoTicket.create()),
                new LottoWinner(4, LottoTicket.create()),
                new LottoWinner(5, LottoTicket.create()),
                new LottoWinner(6, LottoTicket.create())
        );
        LottoPrice price = new LottoPrice(1);
        LottoPrizeInfo prizeInfo = new LottoPrizeInfo(Map.of(
                LottoWinnerClass.FIRST, 4,
                LottoWinnerClass.SECOND, 3,
                LottoWinnerClass.THIRD, 2,
                LottoWinnerClass.FOURTH, 1
        ));

        LottoWinnerStat stat = new LottoWinnerStat(totalTicketCount, new LottoWinners(winners));
        assertThat(stat.getProfitMargin(price, prizeInfo)).isEqualTo(1, withPrecision(0.000001));
    }
}
