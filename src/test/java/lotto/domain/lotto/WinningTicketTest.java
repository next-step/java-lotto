package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.game.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningTicketTest {

  private WinningTicket winningTicket;

  @BeforeEach
  void setUp() {
    winningTicket = new WinningTicket("1, 2, 3, 4, 5, 6", 7);
  }

  @Test
  @DisplayName("5개 일치 + 보너스 일치 시 2등")
  void match_5개_보너스_일치_2등() {
    LottoTicket ticket = new LottoTicket("1, 2, 3, 4, 5, 7");
    assertThat(winningTicket.match(ticket)).isEqualTo(Rank.SECOND);
  }

  @Test
  @DisplayName("5개 일치 + 보너스 불일치 시 3등")
  void match_5개_보너스_불일치_3등() {
    LottoTicket ticket = new LottoTicket("1, 2, 3, 4, 5, 8");
    assertThat(winningTicket.match(ticket)).isEqualTo(Rank.THIRD);
  }

  @ParameterizedTest
  @CsvSource({
      "1, 2, 3, 4, 5, 6, FIRST",
      "1, 2, 3, 4, 8, 9, FOURTH",
      "1, 2, 3, 7, 9, 10, FIFTH",
      "1, 2, 8, 9, 10, 11, NONE"
  })
  void match_3개_일치_5등(int n1, int n2, int n3, int n4, int n5, int n6, Rank rank) {
    LottoTicket ticket = new LottoTicket(n1, n2, n3, n4, n5, n6);
    assertThat(winningTicket.match(ticket)).isEqualTo(rank);
  }

}