package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.RepeatedTest.LONG_DISPLAY_NAME;

class LottoNumberTest {

  @DisplayName("로또 번호는 1~45 숫자중 랜덤 숫자를 반환한다.")
  @RepeatedTest(value = 1_000, name = LONG_DISPLAY_NAME)
  void generate() {
    // given
    int random = randomNumber();

    // when
    LottoNumber lottoNumber = LottoNumber.generate(random);

    // then
    assertThat(lottoNumber).isNotNull();
  }

  @Test
  @DisplayName("로또 번호는 1~45 숫자여야만 생성할 수 있다.")
  void generate_error() {
    assertAll(() -> assertThatThrownBy(() -> LottoNumber.generate(46))
                    .isInstanceOf(IllegalArgumentException.class)
            , () -> assertThatThrownBy(() -> LottoNumber.generate(0))
                    .isInstanceOf(IllegalArgumentException.class));
  }

  private int randomNumber() {
    return new Random().nextInt(45) + 1;
  }
}
