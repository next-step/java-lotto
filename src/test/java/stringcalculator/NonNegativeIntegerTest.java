package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static stringcalculator.NonNegativeInteger.ZERO;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NonNegativeIntegerTest {

  static Stream<Arguments> createSource() {
    return Stream.of(
        arguments(new NonNegativeInteger(), new NonNegativeInteger(ZERO)),
        arguments(new NonNegativeInteger(0), new NonNegativeInteger(ZERO)),
        arguments(new NonNegativeInteger("0"), new NonNegativeInteger(ZERO)),
        arguments(new NonNegativeInteger(1), new NonNegativeInteger(1)),
        arguments(new NonNegativeInteger("1"), new NonNegativeInteger(1)),
        arguments(new NonNegativeInteger(10), new NonNegativeInteger(10)),
        arguments(new NonNegativeInteger("10"), new NonNegativeInteger(10))
    );
  }

  @ParameterizedTest
  @DisplayName("생성 테스트")
  @MethodSource("createSource")
  void create(NonNegativeInteger actual, NonNegativeInteger expected) {
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  @DisplayName("음수는 생성 시도시 NegativeNumberException이 발생한다.")
  void negativeNumberCreation() {
    assertAll(
        () -> assertThatThrownBy(
            () -> new NonNegativeInteger(-1)
        ).isInstanceOf(NegativeNumberException.class),
        () -> assertThatThrownBy(
            () -> new NonNegativeInteger("-1")
        ).isInstanceOf(NegativeNumberException.class)
    );
  }
}
