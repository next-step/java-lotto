package lotto2.util;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;
import lotto2.domain.LottoTicket;
import lotto2.domain.Prize;
import org.junit.jupiter.api.Test;

class LottoResultCalculatorTest {

  @Test
  void 발급된_로또티켓에서_당첨결과를_Map형식으로_검증() {
    LottoTicket ticket1 = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
    LottoTicket ticket2 = new LottoTicket(List.of(1, 2, 3, 4, 5, 7));
    LottoTicket ticket3 = new LottoTicket(List.of(1, 2, 3, 4, 8, 9));


    List<LottoTicket> lottoTickets = List.of(ticket1, ticket2, ticket3);

    List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);


    Map<Prize, Long> result = LottoResultCalculator.calculate(lottoTickets, winningNumbers);

    assertThat(result.getOrDefault(Prize.FIRST,0L)).isEqualTo(1);
    assertThat(result.getOrDefault(Prize.SECOND,0L)).isEqualTo(1);
    assertThat(result.getOrDefault(Prize.THIRD,0L)).isEqualTo(1);
    assertThat(result.getOrDefault(Prize.FOURTH,0L)).isEqualTo(0);
  }
}