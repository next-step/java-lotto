package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class LottoTest {

  @Test
  void 로또_번호_생성() {
    assertThat(new Lotto().toString().split(",")).hasSize(6);
  }

  @Test
  void 번호가_범위_미만이면_예외_발생() {
    assertThatThrownBy(() -> new Lotto(Arrays.asList(0, 2, 3, 4, 5, 6)))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("로또 번호는 1부터 50 사이의 숫자여야 합니다.");
  }

  @Test
  void 번호가_범위_초과면_예외_발생() {
    assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 51)))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("로또 번호는 1부터 50 사이의 숫자여야 합니다.");
  }

  @Test
  void 당첨_번호와_일치하는_개수_계산() {
    Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));

    int matchCount = lotto.countMatchingNumbers(winningNumbers);

    assertThat(matchCount).isEqualTo(3);
  }
} 