package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.domain.game.Rank;
import lotto.domain.result.GameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

  @Test
  @DisplayName("여러 티켓의 당첨 결과가 올바르게 집계된다")
  void match_multiple_tickets() {
    LottoTickets tickets = new LottoTickets(List.of(
        new LottoTicket("1, 2, 3, 10, 11, 12"),
        new LottoTicket("1, 2, 3, 20, 21, 22"),
        new LottoTicket("1, 2, 3, 30, 31, 32")
    ));
    WinningTicket winning = new WinningTicket("1, 2, 3, 4, 5, 6", 7);

    GameResult result = tickets.match(winning);

    GameResult expected = new GameResult(Map.of(Rank.FIFTH, 3));
    assertThat(result.toString()).isEqualTo(expected.toString());
  }
}