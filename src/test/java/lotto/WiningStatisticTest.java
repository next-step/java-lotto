package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class WiningStatisticTest {

    @DisplayName(value = "통계를 구하기 위한 3개, 4개, 5개, 6개 당첨 개수를 확인")
    @Test
    void 통계_개수_테스트() {
        // given
        int purchaseNumber = 3;
        List<Integer> testTicket = Arrays.asList(1, 2, 3, 4, 5, 45);
        LottoTicket testLottoTicket = new LottoTicket(testTicket);
        LottoTickets lottoTickets = LottoTickets.newTickets(purchaseNumber, () -> testLottoTicket);

        List<Integer> lastWeeksWinningNumbers = Arrays.asList(1, 2, 3, 4, 5, 45);

        // when
        List<Integer> winningCounts = WiningStatistic.winningCounts(lottoTickets, lastWeeksWinningNumbers);
        List<Integer> expect = Arrays.asList(0, 0, 0, 6);

        // then
        Assertions.assertThat(winningCounts).isEqualTo(expect);
    }
}