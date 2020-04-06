package lotto.domain;

import lotto.common.LottoStub;
import lotto.domain.machine.LottoTicket;
import lotto.domain.machine.LottoTickets;
import lotto.domain.matcher.LottoRank;
import lotto.domain.matcher.WinningTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

    @DisplayName("로또 티켓 묶음의 당첨 여부를 조회할 수 있다")
    @Test
    public void checkRankTest() {
        LottoTickets lottoTickets = new LottoTickets(
                new LottoTicket(LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 6)),
                new LottoTicket(LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 7)),
                new LottoTicket(LottoStub.getLottoNumbers(1, 2, 3, 4, 6, 7)),
                new LottoTicket(LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 45)),
                new LottoTicket(LottoStub.getLottoNumbers(1, 2, 3, 4, 44, 45)),
                new LottoTicket(LottoStub.getLottoNumbers(1, 2, 3, 43, 44, 45)),
                new LottoTicket(LottoStub.getLottoNumbers(1, 2, 42, 43, 44, 45)),
                new LottoTicket(LottoStub.getLottoNumbers(1, 41, 42, 43, 44, 45)),
                new LottoTicket(LottoStub.getLottoNumbers(40, 41, 42, 43, 44, 45))
        );

        WinningTicket winningTicket = new WinningTicket(LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 6), 7);
        List<LottoRank> lottoRanks = lottoTickets.checkRank(winningTicket);

        assertThat(lottoRanks.get(0)).isEqualTo(LottoRank.SIX);
        assertThat(lottoRanks.get(1)).isEqualTo(LottoRank.FIVE_BONUS);
        assertThat(lottoRanks.get(2)).isEqualTo(LottoRank.FIVE_BONUS);
        assertThat(lottoRanks.get(3)).isEqualTo(LottoRank.FIVE);
        assertThat(lottoRanks.get(4)).isEqualTo(LottoRank.FOUR);
        assertThat(lottoRanks.get(5)).isEqualTo(LottoRank.THREE);
        assertThat(lottoRanks.get(6)).isEqualTo(LottoRank.TWO);
        assertThat(lottoRanks.get(7)).isEqualTo(LottoRank.ONE);
        assertThat(lottoRanks.get(8)).isEqualTo(LottoRank.ZERO);
    }

}
