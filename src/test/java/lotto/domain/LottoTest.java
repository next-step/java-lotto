package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
  @Test
  @DisplayName("로또 한 장은 6개의 숫자로 이루어져있다.")
  void lottoSize() {
    LottoGenerator lottoGenerator = new RandomLottoGenerator();
    Lotto lotto = Lotto.generateLotto(lottoGenerator);

    assertThat(lotto).hasSize(6);

  }

  @Test
  @DisplayName("로또 숫자는 1부터 45까지의 숫자다.")
  void lottoNumberRange() {
    LottoGenerator lottoGenerator = new RandomLottoGenerator();
    Lotto lotto = Lotto.generateLotto(lottoGenerator);

    assertThat(lotto).allMatch(number -> number >= 1 && number <= 45);
  }

}
