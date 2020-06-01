package lotto.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoNumbersTest {

  @ParameterizedTest
  @MethodSource("numberListProvider")
  void getNumbers(List<Integer> numberList) {
    assertThat(new LottoNumbers(numberList).getNumbers()).isEqualTo(numberList);
  }

  static Stream<Arguments> numberListProvider() {
    return Stream.of(
        arguments(Arrays.asList(1, 2, 3, 4, 5, 6))
    );
  }

  @ParameterizedTest
  @MethodSource("wrongNumberListProvider")
  void getNumbers_개수가6개가아닌경우(List<Integer> numberList) {
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
      new LottoNumbers(numberList).getNumbers();
    });
  }

  static Stream<Arguments> wrongNumberListProvider() {
    return Stream.of(
        arguments(Arrays.asList(1, 2, 3, 4, 5)),
        arguments(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
    );
  }
}