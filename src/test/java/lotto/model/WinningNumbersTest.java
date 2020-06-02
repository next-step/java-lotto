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
        arguments(new String[]{"1", "2", "3", "4", "5", "6"}, Arrays.asList(1, 2, 3, 4, 5, 6)),
        arguments("1, 2, 3, 4, 5, 6".split(","), Arrays.asList(1, 2, 3, 4, 5, 6))
    );
  }

  @ParameterizedTest
  @MethodSource("numberListWithPrizeTierProvider")
  void getPrizeTier(String[] strArr, LottoNumbers numbers, PrizeTier prizeTier) {
    WinningNumbers winningNumbers = WinningNumbers.newInstanceByStrArr(strArr);

    assertThat(winningNumbers.getPrizeTier(numbers)).isEqualTo(prizeTier);
  }

  static Stream<Arguments> numberListWithPrizeTierProvider() {
    return Stream.of(
        arguments(new String[]{"1", "2", "3", "4", "5", "6"},
            new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)),
            PrizeTier.MATCH_SIX
        ),
        arguments(new String[]{"1", "2", "3", "4", "5", "6"},
            new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 7)),
            PrizeTier.MATCH_FIVE
        ),
        arguments(new String[]{"1", "2", "3", "4", "5", "6"},
            new LottoNumbers(Arrays.asList(1, 2, 3, 4, 7, 8)),
            PrizeTier.MATCH_FOUR
        ),
        arguments(new String[]{"1", "2", "3", "4", "5", "6"},
            new LottoNumbers(Arrays.asList(1, 2, 3, 7, 8, 9)),
            PrizeTier.MATCH_THREE
        ),
        arguments(new String[]{"1", "2", "3", "4", "5", "6"},
            new LottoNumbers(Arrays.asList(1, 2, 7, 8, 9, 10)),
            PrizeTier.MATCH_ZERO
        ), arguments(new String[]{"1", "2", "3", "4", "5", "6"},
            new LottoNumbers(Arrays.asList(1, 7, 8, 9, 10, 11)),
            PrizeTier.MATCH_ZERO
        ),
        arguments(new String[]{"1", "2", "3", "4", "5", "6"},
            new LottoNumbers(Arrays.asList(7, 8, 9, 10, 11, 12)),
            PrizeTier.MATCH_ZERO
        )
    );
  }
}