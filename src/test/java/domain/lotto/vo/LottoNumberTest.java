package domain.lotto.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

  @Test
  @DisplayName("로또 번호가 아닌 값이 생성 가능한지 확인한다")
  void createZeroLottoNumber() {
    assertThrows(IllegalArgumentException.class, () -> new LottoNumber(0));
    assertThrows(IllegalArgumentException.class, () -> new LottoNumber(46));
  }

  @Test
  @DisplayName("로또 번호가 동일하면 다른 인스턴스도 동일하다고 판단한다")
  void equalsSameLottoNumber() {
    assertThat(new LottoNumber(12)).isEqualTo(new LottoNumber(12));
  }

}
