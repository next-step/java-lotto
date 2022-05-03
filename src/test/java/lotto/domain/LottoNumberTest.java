package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

  @ParameterizedTest
  @DisplayName("숫자를 받아 로또 번호가 제대로 생성되는지 확인")
  @ValueSource(ints = {1, 10, 30, 45})
  void generateInt(int value) {
    LottoNumber lottoNumber = LottoNumber.of(value);

    assertThat(lottoNumber).usingRecursiveComparison().isEqualTo(LottoNumber.of(value));
  }

  @ParameterizedTest
  @DisplayName("문자열을 받아 로또 번호가 제대로 생성되는지 확인")
  @ValueSource(strings = {"1", "10", "30", "45"})
  void generateStr(int value) {
    LottoNumber lottoNumber = LottoNumber.of(value);

    assertThat(lottoNumber).usingRecursiveComparison().isEqualTo(LottoNumber.of(value));
  }

  @ParameterizedTest
  @DisplayName("범위 밖의 로또번호일 경우 에러 발생")
  @ValueSource(ints = {LottoNumber.MAX + 1, -1, 0})
  void error(int value) {
    assertThatThrownBy(
        () -> {
          LottoNumber lottoNumber = LottoNumber.of(value);
        });

  }
}