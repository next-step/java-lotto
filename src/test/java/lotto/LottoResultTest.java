package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @Test
    @DisplayName("당첨 티켓과 구매 티켓을 받아서 결과를 계산할 수 있다.")
    void shouldCalculateRanks() {
        // given
        WinningNumbers winningTicket = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoTickets tickets = LottoTickets.fromManualTickets(
            List.of(
                new LottoTicket(List.of(1, 2, 3, 4, 5, 6)),
                new LottoTicket(List.of(1, 2, 3, 4, 5, 7))
            ));
        LottoResult lottoResult = LottoResult.createLottoResult(winningTicket, tickets);

        // then
        assertThat(lottoResult).isEqualTo(new LottoResult(List.of(LottoRank.FIRST, LottoRank.SECOND)));
    }

    @Test
    @DisplayName("전체 당첨 금액을 계산할 수 있다.")
    void shouldCalculateTotalPrizeMoney() {
        // given
        List<LottoRank> lottoRanks = List.of(LottoRank.FIRST, LottoRank.SECOND);
        LottoResult lottoResult = new LottoResult(lottoRanks);

        // when
        int totalPrizeMoney = lottoResult.calculateTotalPrizeMoney();

        // then
        assertThat(totalPrizeMoney).isEqualTo(2030000000);
    }
}