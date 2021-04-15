package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoBonusBallTest {

  @Test
  @DisplayName("보너스 볼을 생성한다.")
  void create() {
    // given
    int number = 1;

    // when
    LottoBonusBall bonusBall = LottoBonusBall.valueOf(number);

    // then
    assertThat(bonusBall).isEqualTo(LottoNumber.generate(1));
  }
}