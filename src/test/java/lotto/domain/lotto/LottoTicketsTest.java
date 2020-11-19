package lotto.domain.lotto;

import lotto.domain.rank.Rank;
import lotto.domain.rank.LottoRankCalculator;
import org.junit.jupiter.api.Test;
import lotto.dto.WinLotteryResult;

import java.util.List;

import static lotto.domain.lotto.LottoTicketMockFactory.createLottoHasNumberOneToSix;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketsTest {
    @Test
    void of_return_empty_obj_when_receive_null() {
        // when
        final LottoTickets result = LottoTickets.of(null);

        // then
        assertThat(result).isEqualTo(LottoTickets.EMPTY);
    }

    @Test
    void size() {
        // given
        final List<LottoTicket> lottoTicketList = LottoTicketMockFactory.createFourTeenLotto();
        final LottoTickets lottoTickets = LottoTickets.of(lottoTicketList);

        // when
        final int result = lottoTickets.size();

        // then
        assertThat(result).isEqualTo(lottoTicketList.size());
    }


    @Test
    void countHitNumber() {
        // given
        final LottoTickets lottoTickets = LottoTickets.of(LottoTicketMockFactory.createFourTeenLotto());
        final LottoTicket winningLotto = createLottoHasNumberOneToSix();
        final LottoRankCalculator lottoRankCalculator = new LottoRankCalculator();
        final LottoNumber bonusNumber = LottoNumber.MAX;

        // when
        final WinLotteryResult result = lottoRankCalculator.calculateWinLotteryResult(lottoTickets, winningLotto, bonusNumber);

        // then
        assertAll(
                () -> assertThat(result.getFirstRank().getCount()).isEqualTo(0),
                () -> assertThat(result.getSecondRank().getCount()).isEqualTo(0),
                () -> assertThat(result.getThirdRank().getCount()).isEqualTo(0),
                () -> assertThat(result.getFourthRank().getCount()).isEqualTo(0),
                () -> assertThat(result.getFifthRank().getCount()).isEqualTo(1),
                () -> assertThat(result.getTotalPrizeMoney()).isEqualTo(Rank.FIFTH.getWinningMoney())
        );
    }
}