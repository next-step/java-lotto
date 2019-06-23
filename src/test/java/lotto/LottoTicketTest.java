package lotto;

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
}
