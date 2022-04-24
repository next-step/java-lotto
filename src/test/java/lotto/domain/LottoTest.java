package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

  @DisplayName("Integer 리스트를 받아 Lotto를 생성할 수 있다.")
  @Test
  void createLotto() {
    List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);
    List<LottoNumber> lottoNumbers = List.of(
      new LottoNumber(1),
      new LottoNumber(2),
      new LottoNumber(3),
      new LottoNumber(4),
      new LottoNumber(5),
      new LottoNumber(6)
    );
    Lotto expectedResult = new Lotto(lottoNumbers);
    assertThat(Lotto.createLotto(integers)).isEqualTo(expectedResult);
  }

  @DisplayName("1~45 범위가 아닌 숫자가 포함되어있다면, 예외가 발생한다.")
  @Test
  void createLotto_invalid_number() {
    List<Integer> invalidNumbers = List.of(-1, 0, 3, 4, 5, 46);
    assertThatThrownBy(() -> Lotto.createLotto(invalidNumbers))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
