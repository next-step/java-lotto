package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

  @Test
  @DisplayName("로또 생성")
  void givenLottoNumbers_ShouldCreatedTicket() {
    assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6))).isEqualTo(
        new Lotto(List.of(1, 2, 3, 4, 5, 6)));
  }

  @Test
  @DisplayName("로또 번호 6자리 아닐 경우 예외 처리")
  void givenIllegalSizeNumbers_ShouldException() {
    assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)));
    assertThatIllegalArgumentException().isThrownBy(
        () -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)));
  }

}