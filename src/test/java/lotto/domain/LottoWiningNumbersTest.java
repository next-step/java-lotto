package lotto.domain;

import lotto.function.SixLottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWiningNumbersTest {

  @Test
  @DisplayName("로또 당첨 번호를 생성한다.")
  void generate() {
    // given

    // when
    LottoWiningNumbers lottoWiningNumbers = LottoWiningNumbers.generate(new SixLottoNumbers());

    // then
    assertThat(lottoWiningNumbers).isNotNull();
  }
}