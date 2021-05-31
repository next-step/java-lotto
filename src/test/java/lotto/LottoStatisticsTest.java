package lotto;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    @Test
    void getLottoBuyingCount() {
        assertThat(LottoStatistics.getLottoBuyingCount(14000)).isEqualTo(14);
    }

    @Test
    void calculateLottoTicketProfit() {
        LottoTicket lottoTicket = new LottoTicket(1);
        List<Integer> lottoNum = lottoTicket.lottoList().get(0).lottoNum();
        lottoTicket.compareWinList(lottoNum, 100);
        BigDecimal bg1 = new BigDecimal(LottoWin.FIRST_PLACE.winPrice());
        BigDecimal bg2 = new BigDecimal(1000);
        assertThat(LottoStatistics.calculateLottoTicketProfit(lottoTicket)).isEqualTo(bg1.divide(bg2, 2, BigDecimal.ROUND_HALF_DOWN).doubleValue());
    }

    @Test
    void countLottoWinNumMatch() {
        LottoTicket lottoTicket = new LottoTicket(1);
        List<Integer> lottoNum = lottoTicket.lottoList().get(0).lottoNum();
        lottoTicket.compareWinList(lottoNum, 100);

        assertThat(LottoStatistics.countLottoWinNumMatch(lottoTicket.lottoList(), LottoWin.FIRST_PLACE)).isEqualTo(1);
        assertThat(LottoStatistics.countLottoWinNumMatch(lottoTicket.lottoList(), LottoWin.FOURTH_PLACE)).isEqualTo(0);
        assertThat(LottoStatistics.countLottoWinNumMatch(lottoTicket.lottoList(), LottoWin.THIRD_PLACE)).isEqualTo(0);
    }


}

