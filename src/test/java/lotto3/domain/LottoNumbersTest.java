package lotto3.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

  @Test
  void 당첨번호_중에서_3개를_맞춘경우_검증() {
    LottoNumbers lottoNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));

    LottoNumbers winningNumbers = new LottoNumbers(List.of(1, 2, 3, 43, 44, 45));

    assertThat(lottoNumbers.countMatch(winningNumbers)).isEqualTo(3);
  }

  @Test
  void 당첨번호_중에서_하나도_맞히지_않은_경우_검증() {
    LottoNumbers lottoNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));

    LottoNumbers winningNumbers = new LottoNumbers(List.of(11, 12, 13, 43, 44, 45));

    assertThat(lottoNumbers.countMatch(winningNumbers)).isEqualTo(0);
  }

  @Test
  void 로또번호_생성될때_6자리_숫자로_이루어지지_않다면_예외_발생() {
    assertThatThrownBy(() -> new LottoNumbers(List.of(1, 2, 3, 4, 5)))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("로또 번호는 6개만 가질 수 있습니다.");
  }

  @Test
  void 로또번호_생성될때_중복된_숫자가_있으면_예외_발생() {
    assertThatThrownBy(() -> new LottoNumbers(List.of(1, 2, 3, 4, 5, 5)))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("로또 번호는 중복될 수 없습니다.");
  }

  @Test
  void 로또번호_생성될때_숫자가_1과_45_사이가_아니면_예외_발생() {
    assertThatThrownBy(() -> new LottoNumbers(List.of(1, 2, 3, 4, 5, 46)))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("로또 번호는 1부터 45까지의 숫자만 가능합니다.");
  }

  @Test
  void 로또번호가_가지는_contains_동작_검증() {
    LottoNumbers lottoNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));

    assertThat(lottoNumbers.contains(new LottoNumber(1))).isTrue();
    assertThat(lottoNumbers.contains(new LottoNumber(7))).isFalse();
  }
}