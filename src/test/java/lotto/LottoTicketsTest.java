package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

  @Test
  @DisplayName("티켓 생성 테스트")
  void testOf() {
    assertThatExceptionOfType(NullPointerException.class).isThrownBy(
        () -> LottoTickets.of(null)
    );
  }

  @Test
  @DisplayName("티켓 리스트 출력 기능(toString())")
  void testToString() {
    LottoTicket sampleTicket = NumberPool.publishTicket();
    List<LottoTicket> t = new ArrayList<>();
    for (int i = 0; i < 2; i++) {
      t.add(sampleTicket);
    }
    LottoTickets tickets = LottoTickets.of(t);
    assertThat(tickets.toString())
        .isEqualTo(sampleTicket.toString() + '\n' + sampleTicket.toString() + "\n");
  }

}
