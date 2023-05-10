package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    @DisplayName("로또 매칭 테스트")
    @Test
    void getMatchesFromLottoTicket() {
        List<Lotto> lottos = List.of(
                Lotto.from("1, 2, 3, 4, 5, 6"),
                Lotto.from("2, 3, 4, 5, 6, 7"),
                Lotto.from("3, 4, 5, 6, 7, 8"),
                Lotto.from("4, 5, 6, 7, 8, 9")
        );
        LottoTicket ticket = LottoTicket.of(lottos);
        Matches matches = ticket.getMatches(Lotto.from("1, 2, 3, 4, 5, 6"));

        assertThat(matches.getMatches())
                .containsExactlyInAnyOrder(Match.THREE, Match.FOUR, Match.FIVE, Match.SIX);
    }
}
