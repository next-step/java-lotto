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
                LottoTicket.of(1, 2, 3, 4, 5, 6),
                LottoTicket.of(2, 3, 4, 5, 6, 7),
                LottoTicket.of(3, 4, 5, 6, 7, 8)
        ));
    }

    @DisplayName("당첨 로또와 비교해서 등수 배열을 구할 수 있다.")
    @Test
    void match() {
        // given
        LottoTicket winning = LottoTicket.of(1, 2, 3, 4, 5, 6);

        // when
        List<Rank> ranks = lottoTickets.match(winning);

        // then
        assertThat(ranks).containsExactly(Rank.FIRST, Rank.SECOND, Rank.THIRD);
    }
}
