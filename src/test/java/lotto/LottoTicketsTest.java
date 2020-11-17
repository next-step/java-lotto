package lotto;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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
}
