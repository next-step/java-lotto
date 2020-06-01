package lotto.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningNumbersTest {

  @ParameterizedTest
  @MethodSource("numberListProvider")
  void newInstanceByStrArr(String[] strArr, List<Integer> numberList) {
    assertThat(WinningNumbers.newInstanceByStrArr(strArr).getNumbers().values())
        .isEqualTo(numberList);
  }

  static Stream<Arguments> numberListProvider() {
    return Stream.of(
        arguments(new String[]{"1", "2", "3", "4", "5", "6"}, Arrays.asList(1, 2, 3, 4, 5, 6))
    );
  }
}