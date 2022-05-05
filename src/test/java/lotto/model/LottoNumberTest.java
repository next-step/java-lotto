package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

  @Test
  @DisplayName("로또 번호 한개를 객체로 생성한다")
  void createLottoNumberAsObject() {
    // given
    int value = 1;

    // when
    LottoNumber lottoNumber = new LottoNumber(value);

    // then
    assertThat(lottoNumber.getValue()).isEqualTo(value);
  }

  @ParameterizedTest
  @DisplayName("로또의 번호가 1 ~ 45 사이의 값이 아닌 {0}인 경우, 예외가 발생한다")
  @ValueSource(ints = {0, 46})
  void exceptionNotLottoNumberBetweenOneAndFortyFive(int value) {
    // when & then
    assertThatThrownBy(() -> new LottoNumber(value))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest(name = "로또 번호인 {0}와 지난주 우승 번호인 {1}이 같은지 비교")
  @CsvSource({"1,1,true", "1,2,false"})
  void compareLottoNumberForSame(int purchasedNumber, int otherNumber, boolean expected) {
    // given
    LottoNumber lottoNumber1 = LottoNumber.create(purchasedNumber);
    LottoNumber lottoNumber2 = LottoNumber.create(otherNumber);

    // when
    boolean result = lottoNumber1.equals(lottoNumber2);

    // then
    assertThat(result).isEqualTo(expected);
  }
}
