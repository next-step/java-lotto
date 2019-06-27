package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

  @Test
  void winNumberSize() {
    LottoTickets lottoTickets = new LottoTickets(Arrays.asList(
        new LottoTicket(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6))),
        new LottoTicket(new LottoNumber(Arrays.asList(1, 2, 3, 7, 10, 20)))));
    List<Integer> winNumber = Arrays.asList(1, 2, 3, 6, 33, 40);

    List<Rank> ranks = Arrays.asList(
        Rank.valueOf(4, false),
        Rank.valueOf(3, true));

    assertThat(lottoTickets.winNumberSize(winNumber, 44).equals(ranks)).isTrue();
  }
}
