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
    assertThat(new LottoNumbers(numberList).values()).isEqualTo(numberList);
  }

  @ParameterizedTest
  @MethodSource("numberListProvider")
  void checkLottoNumberSize(List<Integer> numberList) {
    new LottoNumbers(numberList);
  }

  static Stream<Arguments> numberListProvider() {
    return Stream.of(
        arguments(Arrays.asList(1, 2, 3, 4, 5, 6)),
        arguments(Arrays.asList(1, 2, 3, 4, 5, 42))
    );
  }

  @ParameterizedTest
  @MethodSource("wrongSizeListProvider")
  void checkLottoNumberSize_크기가6이아닌경우(List<Integer> numberList) {
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
      new LottoNumbers(numberList);
    });
  }

  static Stream<Arguments> wrongSizeListProvider() {
    return Stream.of(
        arguments(Arrays.asList(1, 2, 3, 4, 5)),
        arguments(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
    );
  }

  @ParameterizedTest
  @MethodSource("wrongNumberListProvider")
  void checkLottoNumberRange(List<Integer> numberList) {
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
      new LottoNumbers(numberList);
    });
  }

  static Stream<Arguments> wrongNumberListProvider() {
    return Stream.of(
        arguments(Arrays.asList(1, 2, 3, 4, 5, 46)),
        arguments(Arrays.asList(0, 2, 3, 4, 5, 6))
    );
  }

  @ParameterizedTest
  @MethodSource("duplicatedNumberListProvider")
  void checkLottoNumberDuplicated(List<Integer> numberList) {
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
      new LottoNumbers(numberList);
    });
  }

  static Stream<Arguments> duplicatedNumberListProvider() {
    return Stream.of(
        arguments(Arrays.asList(1, 1, 3, 4, 5, 45))
    );
  }
}