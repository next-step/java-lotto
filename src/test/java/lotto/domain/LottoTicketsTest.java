package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

  @DisplayName("당첨 확인")
  @Test
  void winNumberSize() {
    List<LottoTicket> tickets = new ArrayList<>();
    tickets.add(new LottoTicket(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6))));
    tickets.add(new LottoTicket(new LottoNumber(Arrays.asList(1, 2, 3, 7, 10, 20))));
    LottoTickets lottoTickets = new LottoTickets(2,tickets);
    List<Integer> winNumber = Arrays.asList(1, 2, 3, 6, 33, 40);

    List<Rank> ranks = Arrays.asList(
        Rank.valueOf(4, false),
        Rank.valueOf(3, true));

    assertThat(lottoTickets.winNumberSize(winNumber, 44).equals(ranks)).isTrue();
  }

  @DisplayName("수동구매 테스트")
  @Test
  void manualLotto() {
    List<LottoTicket> manualTickets = Arrays.asList(
        new LottoTicket(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6))),
        new LottoTicket(new LottoNumber(Arrays.asList(1, 2, 3, 7, 10, 20))));
    LottoTickets lottoTickets = new LottoTickets(10, manualTickets);

    assertThat(lottoTickets.getTickets()).hasSize(10);
  }
}
