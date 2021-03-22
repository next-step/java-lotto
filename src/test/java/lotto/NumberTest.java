package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberTest {

  @Test
  @DisplayName("[Number] Number 생성 테스트")
  void createLottoNumberTest() {
    Number number = new Number(3);
    assertThat(number).isEqualTo(new Number(3));
  }
}
