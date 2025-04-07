package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

  @DisplayName("유효한 번호로 LottoNumber 객체를 생성할 수 있다.")
  @ParameterizedTest
  @ValueSource(ints = {1, 10, 45})
  void createLottoNumber(int number) {
    // when
    LottoNumber lottoNumber = new LottoNumber(number);

    // then
    assertThat(lottoNumber.getNumber()).isEqualTo(number);
  }

  @DisplayName("1보다 작은 번호로 LottoNumber를 생성하면 예외가 발생한다.")
  @ParameterizedTest
  @ValueSource(ints = {0, -1, -10})
  void createLottoNumberWithTooSmallNumber(int number) {
    // when & then
    assertThatThrownBy(() -> new LottoNumber(number))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("로또 번호는 1부터 45 사이여야 합니다.");
  }

  @DisplayName("45보다 큰 번호로 LottoNumber를 생성하면 예외가 발생한다.")
  @ParameterizedTest
  @ValueSource(ints = {46, 50, 100})
  void createLottoNumberWithTooLargeNumber(int number) {
    // when & then
    assertThatThrownBy(() -> new LottoNumber(number))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("로또 번호는 1부터 45 사이여야 합니다.");
  }

  @DisplayName("같은 숫자의 LottoNumber 객체는 동등하다.")
  @Test
  void lottoNumberEquality() {
    // given
    LottoNumber lottoNumber1 = new LottoNumber(1);
    LottoNumber lottoNumber2 = new LottoNumber(1);

    // when & then
    assertThat(lottoNumber1).isEqualTo(lottoNumber2);
    assertThat(lottoNumber1.hashCode()).isEqualTo(lottoNumber2.hashCode());
  }

  @DisplayName("다른 숫자의 LottoNumber 객체는 동등하지 않다.")
  @Test
  void lottoNumberInequality() {
    // given
    LottoNumber lottoNumber1 = new LottoNumber(1);
    LottoNumber lottoNumber2 = new LottoNumber(2);

    // when & then
    assertThat(lottoNumber1).isNotEqualTo(lottoNumber2);
  }
}
