package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketNumberTest {

  @Test
  @DisplayName("로또 티켓 번호가 min, max 사이의 숫자면 문제 없이 생성된다.")
  void lottoTicketNumberShouldAllowMinAndMaxBound() {
    new LottoTicketNumber(LottoTicketNumber.getMaxBound());
    new LottoTicketNumber(LottoTicketNumber.getMinBound());
  }

  @Test
  @DisplayName("로또 티켓 번호는 1~45 사이의 숫자여야 한다")
  void shouldValidateLottoNumberWithBoundaryValues() {
    assertAll(
        () -> assertThatThrownBy(() -> new LottoTicketNumber(LottoTicketNumber.getMinBound() - 1))
            .isInstanceOf(IllegalArgumentException.class),

        () -> assertThatThrownBy(() -> new LottoTicketNumber(LottoTicketNumber.getMaxBound() + 1))
            .isInstanceOf(IllegalArgumentException.class)
    );

  }
}