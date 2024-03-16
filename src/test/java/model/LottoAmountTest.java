package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoAmountTest {

  @ParameterizedTest
  @ValueSource(ints = {0, -1000, -2000, -100000})
  @DisplayName("로또 구매 금액이 양수가 아닌 경우 익셉션 발생시킨다")
  void lottoAmountTest(int given) {
    assertThatIllegalArgumentException()
        .isThrownBy(() ->
           new LottoAmount(given)
        );
  }
}
