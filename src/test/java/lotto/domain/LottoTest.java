package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import lotto.domain.generate.LottoGenerator;
import lotto.domain.generate.RandomLottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
  @Test
  @DisplayName("로또 한 장은 6개의 숫자로 이루어져있다.")
  void lottoSize() {
    LottoGenerator lottoGenerator = new RandomLottoGenerator();
    Lotto lotto = Lotto.generateLotto(lottoGenerator);

    assertThat(lotto.size()).isEqualTo(Lotto.SIZE);
  }

  @Test
  @DisplayName("로또 숫자는 Lotto.MIN_NUMBER(1)부터 Lotto.MAX_NUMBER(45)까지의 숫자다.")
  void lottoNumberRange() {
    LottoGenerator lottoGenerator = new RandomLottoGenerator();
    Lotto lotto = Lotto.generateLotto(lottoGenerator);

    assertThat(lotto.getNumbers()).allMatch(number -> number >= Lotto.MIN_NUMBER && number <= Lotto.MAX_NUMBER);
  }

  @Test
  @DisplayName("유효하지 않는 로또 번호로 발행 시 IllegalArgumentException 예외를 발생시킨다.")
  void invalidLottoNumberRange() {
    assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)));
  }

  @Test
  @DisplayName("로또 번호가 6개가 아닐 경우 IllegalArgumentException 예외를 발생시킨다.")
  void invalidLottoSize() {
    assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)));
  }

  @Test
  @DisplayName("입력 받은 로또 번호를 로또 객체로 변환할 수 있다.")
  void of() {
    Lotto lotto = Lotto.of("1,2,3,4,5,6");
    assertThat(lotto.size()).isEqualTo(Lotto.SIZE);
  }
}
