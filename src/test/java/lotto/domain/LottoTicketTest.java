package lotto.domain;

import lotto.util.LottoUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {
  @Test
  void 당첨번호와_일치하는_숫자_갯수를_반환한다() {
    LottoTicket lottoTicket = new LottoTicket(new LottoNumbers(Stream.of(1, 2, 3, 4, 5, 6)
                                                                     .map(LottoNumber::new)
                                                                     .collect(Collectors.toList())));
    MatchNumbersCount matchNumbersCount =
        lottoTicket.matchCount(
            LottoUtils.getLottoNumbers(2, 3, 4, 5, 6, 7),
            new LottoNumber(8)
        );
    assertThat(matchNumbersCount).isEqualTo(MatchNumbersCount.MATCH_5);
  }
}