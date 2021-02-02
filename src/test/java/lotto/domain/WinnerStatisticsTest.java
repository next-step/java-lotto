package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerStatisticsTest {
    @DisplayName("1등 1개, 2등 1개, 꽝 1개")
    @Test
    void getRankCount() {
        // given
        WinnerStatistics winnerStatistics = createWinnerStatistics();

        // when
        int resultOfFirst = winnerStatistics.getWinningCountByRank(Rank.FIRST);
        int resultOfSecond = winnerStatistics.getWinningCountByRank(Rank.SECOND);
        int resultOfNone = winnerStatistics.getWinningCountByRank(Rank.NONE);

        // then
        assertThat(resultOfFirst).isEqualTo(1);
        assertThat(resultOfSecond).isEqualTo(1);
        assertThat(resultOfNone).isEqualTo(1);
    }

    @DisplayName("3개 구입하여 1등 1개, 2등 1개일 때 수익률을 확인")
    @Test
    void calculateEarningRate() {
        // given
        WinnerStatistics winnerStatistics = createWinnerStatistics();

        // when
        double earningRate = winnerStatistics.calculateEarningRate();

        // then
        assertThat(earningRate).isEqualTo(676_666.66);
    }

    private WinnerStatistics createWinnerStatistics() {
        LottoTicket winningTicket = createWinningTicket();
        LottoNumber bonusNumber = LottoNumber.of(45);
        GoldenTicket goldenTicket = new GoldenTicket(winningTicket, bonusNumber);
        List<LottoTicket> pickedLottoTickets = new ArrayList<>(createPickedTickets());
        return new WinnerStatistics(goldenTicket, pickedLottoTickets);
    }

    private LottoTicket createWinningTicket() {
        List<LottoNumber> lottoNumbersList = Arrays.asList(
                LottoNumber.of(8),
                LottoNumber.of(21),
                LottoNumber.of(23),
                LottoNumber.of(41),
                LottoNumber.of(42),
                LottoNumber.of(43)
        );
        return new LottoTicket(lottoNumbersList);
    }

    private List<LottoTicket> createPickedTickets() {
        List<LottoNumber> lottoNumberList = Arrays.asList(
                LottoNumber.of(8),
                LottoNumber.of(21),
                LottoNumber.of(23),
                LottoNumber.of(41),
                LottoNumber.of(42),
                LottoNumber.of(43)
        );
        List<LottoNumber> lottoNumberList2 = Arrays.asList(
                LottoNumber.of(8),
                LottoNumber.of(23),
                LottoNumber.of(41),
                LottoNumber.of(42),
                LottoNumber.of(43),
                LottoNumber.of(45)
        );
        List<LottoNumber> lottoNumberList3 = Arrays.asList(
                LottoNumber.of(3),
                LottoNumber.of(8),
                LottoNumber.of(27),
                LottoNumber.of(30),
                LottoNumber.of(35),
                LottoNumber.of(44)
        );
        LottoTicket lottoTicket = new LottoTicket(lottoNumberList);
        LottoTicket lottoTicket2 = new LottoTicket(lottoNumberList2);
        LottoTicket lottoTicket3 = new LottoTicket(lottoNumberList3);
        return Arrays.asList(
                lottoTicket, lottoTicket2, lottoTicket3
        );
    }
}