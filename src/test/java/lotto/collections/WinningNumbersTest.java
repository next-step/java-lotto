package lotto.collections;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningNumbersTest {

  static Stream<Arguments> NON_SIX_ELEMENTS_OF_WINNING_NUMBERS() {
    return Stream.of(
        Arguments.of(Collections.emptyList()),
        Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),
        Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
    );
  }

  @DisplayName("당첨번호는 무조건 6개여야만 한다.")
  @MethodSource("NON_SIX_ELEMENTS_OF_WINNING_NUMBERS")
  @ParameterizedTest
  void 당첨번호의_개수는_6개임이_보장된다(List<Integer> winningNumberList) {
    assertThatThrownBy(
        () -> new WinningNumbers(winningNumberList))
        .isInstanceOf(RuntimeException.class)
        .hasMessage("winning numbers should have only 6 elements.");
  }
}
