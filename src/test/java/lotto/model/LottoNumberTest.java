package lotto.model;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoNumberTest {

  @ParameterizedTest
  @MethodSource("wrongNumberListProvider")
  void checkLottoNumberRange(int number) {
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
      new LottoNumber(number);
    });
  }

  static Stream<Arguments> wrongNumberListProvider() {
    return Stream.of(
        arguments(0),
        arguments(46)
    );
  }
}
