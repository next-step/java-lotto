package lotto.domain;

import lotto.util.LottoUtils;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {
  @Test
  void 티켓_목록을_반환한다() {
    LottoNumbers lottoNumbers1 = LottoUtils.getLottoNumbers(1, 2, 3, 4, 5, 6);
    LottoNumbers lottoNumbers2 = LottoUtils.getLottoNumbers(2, 3, 4, 5, 6, 7);
    List<LottoTicket> expected = Stream.of(lottoNumbers1, lottoNumbers2)
                                      .map(LottoTicket::new)
                                      .collect(Collectors.toList());

    LottoTickets lottoTickets = LottoUtils.getLottoTickets(lottoNumbers1, lottoNumbers2);

    assertThat(lottoTickets.getLottoTickets())
        .isEqualTo(expected);
  }
}