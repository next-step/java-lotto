package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumbersTest {

  @DisplayName("로또 번호는 6개만 가능")
  @Test
  void validateNumbers() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
  }

  @DisplayName("같은 숫자가 중복되지 않아야 함")
  @Test
  void validateDuplicate() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> LottoNumbers.of(Arrays.asList(1, 2, 2, 3, 4, 5)));
  }

  @DisplayName("당첨 번호와 비교")
  @Test
  void compareNumbers() {
    LottoNumbers lottoNumbers = LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6));
    LottoNumbers winNumber = LottoNumbers.of(1,2,3,5,6,7);
    assertThat(lottoNumbers.match(winNumber)).isEqualTo(5);
  }
}
