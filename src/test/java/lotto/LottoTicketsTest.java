package lotto;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static lotto.LottoGameConstant.MINIMUM_LOTTO_NUMBER;
import static lotto.LottoGameConstant.NUMBERS_PER_TICKET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

  LottoTicket sampleTicket;

  @BeforeEach
  void setUp() {
    sampleTicket = IntStream
        .range(MINIMUM_LOTTO_NUMBER, MINIMUM_LOTTO_NUMBER + NUMBERS_PER_TICKET)
        .mapToObj(LottoNumber::get)
        .collect(Collectors.collectingAndThen(toList(), LottoTicket::of));
  }

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
    LottoTicket sampleTicket = TicketPublisher.publishTicket();
    List<LottoTicket> t = new ArrayList<>();
    for (int i = 0; i < 2; i++) {
      t.add(sampleTicket);
    }
    LottoTickets tickets = LottoTickets.of(t);
    assertThat(tickets.toString())
        .isEqualTo(sampleTicket.toString() + '\n' + sampleTicket.toString() + "\n");
  }

  @Test
  @DisplayName("로또 정산 결과가 정상으로 나오는지 테스트")
  void testResult() {

    LottoTickets tickets = IntStream
        .range(0, 2)
        .mapToObj(x -> this.sampleTicket)
        .collect(collectingAndThen(toList(), LottoTickets::of));

    WinningNumber winningNumber = WinningNumber.of("1, 2, 3, 4, 5, 6");

    LottoResult result = tickets.settle(winningNumber);

    assertThat(result.getRecordedNumberOfHit(6))
        .isEqualTo(2);
  }
}
