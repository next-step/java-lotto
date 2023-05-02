package lotto2.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

  @Test
  void 당첨개수_검증() {
    LottoTicket lottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));

    List<Integer> winningNumbers = List.of(1, 2, 3, 45, 44, 43);
    int matchCount = lottoTicket.matchCount(winningNumbers);

    assertThat(matchCount).isEqualTo(3);
  }
}