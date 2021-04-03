package lotto.domain;

import lotto.enums.WinningRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RanksCountTest {

    @Test
    @DisplayName("당첨 등수 세기")
    public void count() throws Exception {
        //given
        WinningNumbers winningNumbers = WinningNumbers.from(1, 2, 3, 4, 5, 6);
        LottoTicket firstTicket = new LottoTicket(LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoTicket secondTicket = new LottoTicket(LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 7)));
        BonusBall bonusBall = new BonusBall(7);
        LottoTickets lottoTickets = new LottoTickets(Arrays.asList(firstTicket, secondTicket));
        RanksCount ranksCount = new RanksCount(winningNumbers, lottoTickets);

        //when
        ranksCount.count(bonusBall);

        //then
        assertThat(ranksCount.countOf(WinningRank.FIRST_PLACE)).isEqualTo(1);
        assertThat(ranksCount.countOf(WinningRank.SECOND_PLACE)).isEqualTo(1);
    }

    @Test
    @DisplayName("총 당첨 금액 구하기")
    public void totalPrize() throws Exception {
        //given
        WinningNumbers winningNumbers = WinningNumbers.from(1, 2, 3, 4, 5, 6);
        LottoTicket firstTicket = new LottoTicket(LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoTicket secondTicket = new LottoTicket(LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 7)));
        LottoTicket thirdTicket = new LottoTicket(LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 8)));
        BonusBall bonusBall = new BonusBall(7);
        LottoTickets lottoTickets = new LottoTickets(Arrays.asList(firstTicket, secondTicket, thirdTicket));
        RanksCount ranksCount = new RanksCount(winningNumbers, lottoTickets);
        ranksCount.count(bonusBall);

        //when
        TotalPrize totalPrize = ranksCount.totalPrize();

        //then
        assertThat(totalPrize.sum()).isEqualTo(WinningRank.FIRST_PLACE.prize().prize() + WinningRank.SECOND_PLACE.prize().prize() + WinningRank.THIRD_PLACE.prize().prize());
    }
}
