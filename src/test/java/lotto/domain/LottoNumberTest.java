package lotto.domain;

import static lotto.domain.LottoNumber.MAXIMUM_NUMBER_BOUND;
import static lotto.domain.LottoNumber.MINIMUM_NUMBER_BOUND;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

  @DisplayName("로또 넘버에 1부터 45 사이의 숫자만 들어갈 수 있다.")
  @Test
  void 로또_넘버는_1부터_45_사이이다() {
    assertThat(new LottoNumber().getNumber()).isBetween(MINIMUM_NUMBER_BOUND, MAXIMUM_NUMBER_BOUND);
  }
}
