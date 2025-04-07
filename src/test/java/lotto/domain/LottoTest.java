package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTest {

  @Test
  void 로또_번호_생성() {
    assertThat(new Lotto().toString().split(",")).hasSize(6);
  }

  @ParameterizedTest
  @CsvSource({
      "0, 2, 3, 4, 5, 6",
      "1, 2, 3, 4, 5, 51"
  })
  void 번호가_범위를_벗어나면_예외_발생(int n1, int n2, int n3, int n4, int n5, int n6) {
    assertThatThrownBy(() -> new Lotto(Arrays.asList(n1, n2, n3, n4, n5, n6)))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
  }

  @Test
  void 당첨_번호와_일치하는_개수_계산() {
    Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));

    assertThat(lotto.countMatchingNumbers(winningNumbers)).isEqualTo(3);
  }

  @ParameterizedTest
  @CsvSource({
      "1, 2, 3, 4, 5, 6, 7, false",
      "1, 2, 3, 4, 5, 6, 6, true"
  })
  void 보너스_볼_일치_여부_확인(int n1, int n2, int n3, int n4, int n5, int n6, int bonusBall, boolean expected) {
    assertThat(new Lotto(Arrays.asList(n1, n2, n3, n4, n5, n6)).hasBonusBall(bonusBall)).isEqualTo(expected);
  }
} 