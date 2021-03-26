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

  static Stream<Arguments> multiplySource() {
    return Stream.of(
        arguments(new Money(1000), 14, new Money(14000)),
        arguments(new Money(1000), 1, new Money(1000)),
        arguments(new Money(1000), 20, new Money(20000)),
        arguments(new Money(1000), 0, new Money(0))
    );
  }

  static Stream<Arguments> multiplySource2() {
    return Stream.of(
        arguments(new Money(1000), 14L, new Money(14000)),
        arguments(new Money(1000), 1L, new Money(1000)),
        arguments(new Money(1000), 20L, new Money(20000)),
        arguments(new Money(1000), 0L, new Money(0))
    );
  }

  static Stream<Arguments> sumSource() {
    return Stream.of(
        arguments(new Money(14000), new Money(1000), new Money(15000)),
        arguments(new Money(1400), new Money(1000), new Money(2400)),
        arguments(new Money(1000), new Money(1000), new Money(2000)),
        arguments(new Money(999), new Money(1000), new Money(1999)),
        arguments(new Money(0), new Money(1000), new Money(1000))
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

  @ParameterizedTest
  @DisplayName("덧셈 테스트")
  @MethodSource("sumSource")
  void sum(Money money1, Money money2, Money expected) {
    assertThat(money1.sum(money2)).isEqualTo(expected);
  }

  @ParameterizedTest
  @DisplayName("곱셈 테스트")
  @MethodSource("multiplySource")
  void divide(Money multiplicand, int multiplier, Money expected) {
    assertThat(multiplicand.multiply(multiplier)).isEqualTo(expected);
  }

  @ParameterizedTest
  @DisplayName("곱셈 테스트(long)")
  @MethodSource("multiplySource2")
  void divide(Money multiplicand, long multiplier, Money expected) {
    assertThat(multiplicand.multiply(multiplier)).isEqualTo(expected);
  }
}
