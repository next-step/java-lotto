package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.ArrayList;
import java.util.Arrays;
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

  @Test
  @DisplayName("로또 정산 결과가 정상으로 나오는지 테스트")
  void testResult() {
    PublishStrategy publishStrategy = () -> {
      List<LottoNumber> numbers = new ArrayList<>(Arrays.asList(
          LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
          LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)));
      return LottoTicket.of(numbers);
    };

    LottoTickets tickets = NumberPool.purchaseTickets(2, publishStrategy);
    WinningNumber winningNumber = WinningNumber.of("1, 2, 3, 4, 5, 6");

    LottoResult result = tickets.settle(winningNumber);

    assertThat(result.getRecordedNumberOfHit(6))
        .isEqualTo(2);
  }
}
