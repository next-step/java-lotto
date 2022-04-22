package lotto.model;

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
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));

        LottoTicket lottoTicket2 = new LottoTicket(Set.of(
                new LottoNumber(2),
                new LottoNumber(4),
                new LottoNumber(6),
                new LottoNumber(8),
                new LottoNumber(10),
                new LottoNumber(13)
        ));

        LottoTickets lottoTickets = new LottoTickets(List.of(lottoTicket, lottoTicket2));

        WinningTicket winningTicket = new WinningTicket(
                new LottoTicket(Set.of(
                        new LottoNumber(2),
                        new LottoNumber(4),
                        new LottoNumber(6),
                        new LottoNumber(8),
                        new LottoNumber(11),
                        new LottoNumber(12))
                ), new LottoNumber(13)
        );

        //when
        List<Rank> ranks = lottoTickets.getRanks(winningTicket);

        //then
        assertThat(ranks).containsExactly(Rank.FIFTH, Rank.SECOND);
    }

}