package util;

import static org.assertj.core.api.Assertions.*;

import domain.LottoTicket;
import domain.Prize;
import domain.RandomNumberGenerator;
import domain.RandomNumberStrategy;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class StatisticalCalculatorTest {


  @Test
  public void 당첨_티켓을_올바르게_카운트_했는지_검증() {
    LottoTicket lottoTicket1 = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
    LottoTicket lottoTicket2 = new LottoTicket(List.of(1, 2, 3, 4, 5, 7));
    LottoTicket lottoTicket3 = new LottoTicket(List.of(1, 2, 3, 4, 8, 9));

    List<LottoTicket> lottoTickets = List.of(lottoTicket1, lottoTicket2, lottoTicket3);

    List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

    Map<Prize, Integer> prizeCountMap = StatisticalCalculator.calculate(lottoTickets, winningNumbers);

    assertThat(prizeCountMap.get(Prize.MATCH_6_TIME)).isEqualTo(1);
    assertThat(prizeCountMap.get(Prize.MATCH_5_TIME)).isEqualTo(1);
    assertThat(prizeCountMap.get(Prize.MATCH_4_TIME)).isEqualTo(1);
  }

  @Test
  public void 당첨티켓을_통해_벌어들인_금액이_맞는지_검증() {
    LottoTicket lottoTicket1 = new LottoTicket(List.of(1, 2, 3, 9, 9, 9));
    LottoTicket lottoTicket2 = new LottoTicket(List.of(1, 2, 3, 4, 9, 9));

    List<LottoTicket> lottoTickets = List.of(lottoTicket1, lottoTicket2);

    List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

    Map<Prize, Integer> prizeCountMap = StatisticalCalculator.calculate(lottoTickets, winningNumbers);

    int earnMoney = StatisticalCalculator.calculateEarnMoney(prizeCountMap);

    assertThat(earnMoney).isEqualTo(55000);
  }

}