package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MoneyTest {

  int money = 1000;

  static Stream<Arguments> divideSource() {
    return Stream.of(
        arguments(new Money(14000), new Money(1000), new Money(14)),
        arguments(new Money(1400), new Money(1000), new Money(1)),
        arguments(new Money(1000), new Money(1000), new Money(1)),
        arguments(new Money(999), new Money(1000), new Money(0)),
        arguments(new Money(0), new Money(1000), new Money(0))
    );
  }

  @Test
  @DisplayName("생성")
  void create() {
    assertThat(new Money(money)).isEqualTo(new Money(money));
  }

  @Test
  @DisplayName("int 타입으로 변환")
  void toInteger() {
    assertThat(new Money(money).toInteger()).isEqualTo(money);
  }

  @ParameterizedTest
  @DisplayName("나눗셈 테스트")
  @MethodSource("divideSource")
  void divide(Money dividend, Money divisor, Money expected) {
    assertThat(dividend.divideBy(divisor)).isEqualTo(expected);
  }
}
