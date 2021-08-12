package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

  @DisplayName("로또번호 입력 최대값 검증.")
  @ParameterizedTest
  @ValueSource(ints = {46,47,100,1000,-1,-10})
  void 로또한자리최대번호값검증(int input) {
    assertThatThrownBy(
        ()->new LottoNumber(input))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("로또넘버 객채 생성 및 비교 테스트.")
  @Test
  void 객체가같은지비교() {
    LottoNumber lottoNumber = new LottoNumber(1);
    assertThat(lottoNumber.equals(new LottoNumber(1))).isTrue();
  }

  @DisplayName("객체 비교를 통한 최대값 초과시 에러발생 테스트.")
  @Test
  void 최대값이상유무() {
    assertThatThrownBy(
        () -> new LottoNumber(46)
    ).isInstanceOf(IllegalArgumentException.class);
  }


  @DisplayName("객체 비교를 통한 최소값 에러발생 테스트.")
  @Test
  void 최소값이상유무() {
    assertThatThrownBy(
        () -> new LottoNumber(-1)
    ).isInstanceOf(IllegalArgumentException.class);
  }
}