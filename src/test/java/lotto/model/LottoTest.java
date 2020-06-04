package lotto.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

  @ParameterizedTest
  @MethodSource("numberListProvider")
  void checkLottoNumberSize(List<LottoNumber> numberList) {
    new Lotto(numberList);
  }

  static Stream<Arguments> numberListProvider() {
    return Stream.of(
        arguments(Arrays.asList(
            new LottoNumber(1, false),
            new LottoNumber(2, false),
            new LottoNumber(3, false),
            new LottoNumber(4, false),
            new LottoNumber(5, false),
            new LottoNumber(6, false)
        )),
        arguments(Arrays.asList(
            new LottoNumber(1, false),
            new LottoNumber(2, false),
            new LottoNumber(3, false),
            new LottoNumber(4, false),
            new LottoNumber(5, false),
            new LottoNumber(42, false)
        ))
    );
  }

  @ParameterizedTest
  @MethodSource("wrongSizeListProvider")
  void checkLottoNumberSize_크기가6이아닌경우(List<LottoNumber> numberList) {
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
      new Lotto(numberList);
    });
  }

  static Stream<Arguments> wrongSizeListProvider() {
    return Stream.of(
        arguments(Arrays.asList(1, 2, 3, 4, 5)),
        arguments(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
    );
  }

  @ParameterizedTest
  @MethodSource("duplicatedNumberListProvider")
  void checkLottoNumberDuplicated(List<LottoNumber> numberList) {
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
      new Lotto(numberList);
    });
  }

  static Stream<Arguments> duplicatedNumberListProvider() {
    return Stream.of(
        arguments(Arrays.asList(1, 1, 3, 4, 5, 45))
    );
  }

  @Test
  void has() {
    assertThat(new Lotto(Arrays.asList(
        new LottoNumber(1, false),
        new LottoNumber(2, false),
        new LottoNumber(3, false),
        new LottoNumber(4, false),
        new LottoNumber(5, false),
        new LottoNumber(42, false)
    )).has(new LottoNumber(1, true))).isEqualTo(true);
  }
}