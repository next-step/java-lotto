package lotto.domain;

import lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTicketTest {

  @DisplayName("로또 번호는 6개만 가능")
  @Test
  void validateNumbers() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
  }

  @DisplayName("같은 숫자가 중복되지 않아야 함")
  @Test
  void validateDuplicate() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> new LottoTicket(Arrays.asList(1, 2, 2, 3, 4, 5)));
  }

  @DisplayName("1~45 사이의 숫자가 아니어야 함")
  @Test
  void validateRangeNumber() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> new LottoTicket(Arrays.asList(0, 2, 3, 4, 5, 6)));
  }
}
