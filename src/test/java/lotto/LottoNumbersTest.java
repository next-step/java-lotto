package lotto;

import static lotto.LottoNumbers.LOTTO_NUMBER_COUNT;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

  @Test
  @DisplayName("생성")
  void create() {
    assertThat(new LottoNumbers().size()).isEqualTo(LOTTO_NUMBER_COUNT);
  }
}
