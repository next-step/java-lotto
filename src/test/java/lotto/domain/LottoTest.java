package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
  @Test
  @DisplayName("로또 한 장은 6개의 숫자로 이루어져있다.")
  void lottoSize() {
    RandomLottoGenerator lottoGenerator = new RandomLottoGenerator();
    Lotto lotto = Lotto.generateRandomLotto(lottoGenerator);

    assertThat(lotto.size()).isEqualTo(Lotto.SIZE);
  }

  @Test
  @DisplayName("로또 번호가 6개가 아닐 경우 IllegalArgumentException 예외를 발생시킨다.")
  void invalidLottoSize() {
    assertThatIllegalArgumentException().isThrownBy(() -> Lotto.of("1, 2, 3, 4, 5"));
  }

  @Test
  @DisplayName("입력 받은 로또 번호를 로또 객체로 변환할 수 있다.")
  void of() {
    Lotto lotto = Lotto.of("1,2,3,4,5,6");
    assertThat(lotto.size()).isEqualTo(Lotto.SIZE);
  }
}
