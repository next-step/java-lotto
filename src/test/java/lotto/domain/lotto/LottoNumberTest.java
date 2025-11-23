package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoNumberTest {

  @ParameterizedTest
  @CsvSource({"0", "46"})
  void numberNotBetween1To45ThrowException(int value) {
    assertThatThrownBy(() -> new LottoNumber(value))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void sameValeSameLottoNumber() {
    assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
  }
}