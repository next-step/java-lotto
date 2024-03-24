package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Currency;
import java.util.Locale;

import static org.assertj.core.api.Assertions.*;

public class AmountTest {
  @ParameterizedTest
  @CsvSource({ "0,false", "1,true", "100000,true" })
  void 상금_금액이_0이아닌지_확인(int input, Boolean expected) {
    assertThat((new Amount(PositiveNumber.of(input), Currency.getInstance(Locale.KOREA))).isPositive()).isEqualTo(expected);
  }
}
