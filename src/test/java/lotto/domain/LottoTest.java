package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
  @Test
  @DisplayName("로또 한 장은 6개의 숫자로 이루어져있다.")
  void lottoSize() {
    LottoGenerator lottoGenerator = new RandomLottoGenerator();
    Lotto lotto = Lotto.generateLotto(lottoGenerator);

    assertThat(lotto.size()).isEqualTo(6);
  }

  @Test
  @DisplayName("로또 숫자는 1부터 45까지의 숫자다.")
  void lottoNumberRange() {
    LottoGenerator lottoGenerator = new RandomLottoGenerator();
    Lotto lotto = Lotto.generateLotto(lottoGenerator);

    assertThat(lotto.getNumbers()).allMatch(number -> number >= 1 && number <= 45);
  }

  @Test
  @DisplayName("유효하지 않는 로또 번호로 발행 시 IllegalArgumentException 예외를 발생시킨다.")
  void invalidLottoNumberRange() {
    assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(Set.of(1, 2, 3, 4, 5, 46)));
  }

  @Test
  @DisplayName("로또 번호가 6개가 아닐 경우 IllegalArgumentException 예외를 발생시킨다.")
  void invalidLottoSize() {
    assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(Set.of(1, 2, 3, 4, 5)));
  }
}
