package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

  @DisplayName("당첨 번호와 비교")
  @Test
  void compareNumbers() {
    LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
    List<Integer> winNumber = Arrays.asList(1, 2, 3, 6, 33, 40);
    assertThat(lottoTicket.winNumberSize(winNumber)).isEqualTo(4);
  }
}
