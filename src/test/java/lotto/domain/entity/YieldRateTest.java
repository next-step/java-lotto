package lotto.domain.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class YieldRateTest {


  @ParameterizedTest
  @ValueSource(doubles = {0.1, 0.5, 0.75, 0.99, 1})
  @DisplayName("소수 값을 넣어 yield를 생성한다.")
  void create(double input) {
    YieldRate yieldRate = new YieldRate(input);
    assertEquals(input, yieldRate.getRate());
  }

  @ParameterizedTest
  @ValueSource(doubles = {-0.1, -0.5, -0.75, -0.99, -1})
  @DisplayName("음수 값을 넣어 yield를 생성하면 exception을 반환한다.")
  void createWithMinus(double input) {
    assertThrows(IllegalArgumentException.class, () -> new YieldRate(input));
  }

  @ParameterizedTest
  @CsvSource(value = {"0.1:true", "0:true", "1:false", "1.5:false"}, delimiter = ':')
  @DisplayName("1이상의 수를 가지고 있으면 false를 반환, 1미만이면 true를 반환한다.")
  void isLessThanOneTest(double input, boolean result) {
    YieldRate yieldRate = new YieldRate(input);
    assertEquals(yieldRate.isYieldRateLessThanOne(), result);
  }

}