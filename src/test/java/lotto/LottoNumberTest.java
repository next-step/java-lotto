package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

  @Test
  @DisplayName("로또번호 생성")
  void givenNumber_ShouldCreated() {
    assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
  }

  @Test
  @DisplayName("로또번호에 포함되지 않는 번호 생성 예외")
  void givenNumber_ShouldException() {
    assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(0));
    assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(46));
  }

}