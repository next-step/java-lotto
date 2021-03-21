package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NonNegativeIntegersTest {

  static Stream<Arguments> createSource() {
    return Stream.of(
        arguments(new String[]{"1", "2"},
            Lists.list(new NonNegativeInteger(1), new NonNegativeInteger(2))
        ),
        arguments(new String[]{"1", "2", "3"},
            Lists.list(new NonNegativeInteger(1), new NonNegativeInteger(2), new NonNegativeInteger(3))
        )
    );
  }

  static Stream<Arguments> sumSource() {
    return Stream.of(
        arguments(new String[]{"1", "2"}, new NonNegativeInteger(3)),
        arguments(new String[]{"1", "2", "3"}, new NonNegativeInteger(6)),
        arguments(new String[]{"4", "8", "9"}, new NonNegativeInteger(21))
    );
  }

  @ParameterizedTest
  @DisplayName("생성자 테스트")
  @MethodSource("createSource")
  void create(String[] numbers, List<NonNegativeInteger> nonNegativeIntegers) {
    assertThat(new NonNegativeIntegers(numbers)).isEqualTo(new NonNegativeIntegers(nonNegativeIntegers));
  }

  @Test
  @DisplayName("음수를 포함하여 생성 시도시 NegativeNumberException이 발생한다.")
  void negativeContainsCreation() {
    assertThatThrownBy(() -> new NonNegativeIntegers(new String[]{"-1", "2"}))
        .isInstanceOf(NegativeNumberException.class);
  }


  @ParameterizedTest
  @DisplayName("합 테스트")
  @MethodSource("sumSource")
  void sum(String[] numbers, NonNegativeInteger expected) {
    assertThat(new NonNegativeIntegers(numbers).sum()).isEqualTo(expected);
  }
}
