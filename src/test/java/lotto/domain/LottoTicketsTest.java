package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

  @Test
  void 가격으로_로또_티켓_생성() {
    assertThat(LottoTickets.of(5000).size()).isEqualTo(5);
  }

  @Test
  void 수익률_계산() {
    Map<Integer, Integer> statistics = new HashMap<>();
    statistics.put(3, 1);
    statistics.put(4, 0);
    statistics.put(5, 0);
    statistics.put(6, 0);
    assertThat(new LottoTickets(5).calculateProfitRate(statistics)).isEqualTo(1.0);
  }
} 