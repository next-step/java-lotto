package lotto.domain;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 티켓들(LottoTickets) 테스트")
public class LottoTicketsTest {

    private LottoTickets lottoTickets;

    @BeforeEach
    void setUp() {
        lottoTickets = LottoTickets.of(Arrays.asList(
                LottoTicket.of(Arrays.asList(
                        LottoNumber.valueOf(1),
                        LottoNumber.valueOf(2),
                        LottoNumber.valueOf(3),
                        LottoNumber.valueOf(4),
                        LottoNumber.valueOf(5),
                        LottoNumber.valueOf(6))
                ),
                LottoTicket.of(Arrays.asList(
                        LottoNumber.valueOf(2),
                        LottoNumber.valueOf(3),
                        LottoNumber.valueOf(4),
                        LottoNumber.valueOf(5),
                        LottoNumber.valueOf(6),
                        LottoNumber.valueOf(7))
                ),
                LottoTicket.of(Arrays.asList(
                        LottoNumber.valueOf(3),
                        LottoNumber.valueOf(4),
                        LottoNumber.valueOf(5),
                        LottoNumber.valueOf(6),
                        LottoNumber.valueOf(7),
                        LottoNumber.valueOf(8))
                )
        ));
    }

    @DisplayName("당첨 로또와 비교해서 등수 배열을 구할 수 있다.")
    @Test
    void match() {
        // given
        LottoTicket winningTicket = LottoTicket.of(Arrays.asList(
                LottoNumber.valueOf(1),
                LottoNumber.valueOf(2),
                LottoNumber.valueOf(3),
                LottoNumber.valueOf(4),
                LottoNumber.valueOf(5),
                LottoNumber.valueOf(6))
        );
        WinningLotto winningLotto = WinningLotto.of(winningTicket, LottoNumber.valueOf(7));

        // when
        List<Rank> ranks = lottoTickets.match(winningLotto);

        // then
        assertThat(ranks).containsExactly(Rank.FIRST, Rank.SECOND, Rank.FOURTH);
    }
}
