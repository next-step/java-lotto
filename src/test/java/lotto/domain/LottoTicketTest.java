package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {
  @Test
  void 당첨번호와_일치하는_숫자_갯수() {
    LottoTicket lottoTicket = new LottoTicket(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
    MatchNumbersCount matchNumbersCount =
        lottoTicket.matchCount(new LottoNumbers(Arrays.asList(2, 3, 4, 5, 6, 7)));
    assertThat(matchNumbersCount).isEqualTo(MatchNumbersCount.MATCH_5);
  }
}