package lotto.domain;

import lotto.domain.result.LottoPrize;
import lotto.domain.result.LottoResult;
import lotto.domain.result.WinningNumbers;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoTicketsTest {

    @DisplayName("당첨번호를 입력하면 당첨통계를 반환한다")
    @Test
    void resultTest() {
        //given
        LottoTickets lottoTickets = createLottoTickets();
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<LottoPrize> expectedLottoPrizes = Arrays.asList(LottoPrize.FIRST, LottoPrize.FOURTH, LottoPrize.FOURTH);

        //when
        LottoResult lottoResult = lottoTickets.getLottoResult(winningNumbers);

        //then
        assertThat(lottoResult.getLottoStatistics()).isEqualTo(expectedLottoPrizes);
    }

    private LottoTickets createLottoTickets() {
        LottoTicket lottoTicket1 = new LottoTicket(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))); // 6
        LottoTicket lottoTicket2 = new LottoTicket(new HashSet<>(Arrays.asList(7, 8, 9, 4, 5, 6))); // 3
        LottoTicket lottoTicket3 = new LottoTicket(new HashSet<>(Arrays.asList(1, 21, 3, 43, 12, 6))); // 3

        return new LottoTickets(Arrays.asList(lottoTicket1, lottoTicket2, lottoTicket3));
    }

}
