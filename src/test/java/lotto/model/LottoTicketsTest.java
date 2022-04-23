package lotto.model;

import lotto.model.lotto.LottoNumber;
import lotto.model.lotto.LottoTicket;
import lotto.model.lotto.LottoTickets;
import lotto.model.lotto.WinningTicket;
import lotto.model.rank.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

    @Test
    @DisplayName("로또 등수를 반환한다")
    void getRanks() {
        //given
        LottoTicket lottoTicket = new LottoTicket(Set.of(
                LottoNumber.create(2),
                LottoNumber.create(4),
                LottoNumber.create(6),
                LottoNumber.create(8),
                LottoNumber.create(11),
                LottoNumber.create(13)
        ));

        LottoTicket lottoTicket2 = new LottoTicket(Set.of(
                LottoNumber.create(2),
                LottoNumber.create(4),
                LottoNumber.create(6),
                LottoNumber.create(8),
                LottoNumber.create(11),
                LottoNumber.create(14)
        ));

        LottoTickets lottoTickets = new LottoTickets(List.of(lottoTicket, lottoTicket2));

        WinningTicket winningTicket = new WinningTicket(
                new LottoTicket(Set.of(
                        LottoNumber.create(2),
                        LottoNumber.create(4),
                        LottoNumber.create(6),
                        LottoNumber.create(8),
                        LottoNumber.create(11),
                        LottoNumber.create(12))
                ), LottoNumber.create(13)
        );

        //when
        List<Rank> ranks = lottoTickets.getRanks(winningTicket);

        //then
        assertThat(ranks).containsExactly(Rank.SECOND, Rank.THIRD);
    }

}