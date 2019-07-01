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
    tickets.add(new LottoTicket(LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6))));
    tickets.add(new LottoTicket(LottoNumbers.of(Arrays.asList(1, 2, 3, 7, 10, 20))));
    LottoTickets lottoTickets = LottoTickets.of(tickets);
    WinNumber winNumber = new WinNumber(LottoNumbers.of(Arrays.asList(1, 2, 3, 6, 33, 40)), LottoNumber.of(44));

    List<Rank> ranks = Arrays.asList(
        Rank.valueOf(4, false),
        Rank.valueOf(3, true));

    assertThat(lottoTickets.winNumberSize(winNumber).equals(ranks)).isTrue();
  }

  @DisplayName("수동구매 테스트")
  @Test
  void manualLotto() {
    List<LottoTicket> manualTickets = Arrays.asList(
        new LottoTicket(LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6))),
        new LottoTicket(LottoNumbers.of(Arrays.asList(1, 2, 3, 7, 10, 20))));
    LottoTickets lottoTickets = LottoTickets.of(manualTickets);

    assertThat(lottoTickets.getTickets()).hasSize(2);
  }
}
