package lotto.domain;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.FAILURE;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningNumbersTest {

  private static final String DELIMITER = ",";
  private static final Set<Integer> LOTTO_NUMBERS = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
  private static final WinningNumbers WINNING_NUMBERS = new WinningNumbers(
      LOTTO_NUMBERS,
      7
  );

  private LottoGame buildLottoNumbers(String numbers) {
    Set<Integer> integers = Arrays.stream(numbers.split(DELIMITER))
        .map(Integer::parseInt)
        .collect(Collectors.toSet());

    return new LottoGame(integers);
  }

  @DisplayName("Test for illegal argument")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4, 5, 6})
  public void IllegalArgumentTest(int bonus) {
    assertThatThrownBy(() -> new WinningNumbers(LOTTO_NUMBERS, bonus))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("Test for Lotto which takes the first place")
  @Test
  public void firstPlaceTest() {
    assertThat(WINNING_NUMBERS.getRank(new LottoGame(LOTTO_NUMBERS))).isEqualTo(FIRST);
  }

  @DisplayName("Test for Lotto which takes the second place")
  @ParameterizedTest
  @ValueSource(strings = {"1,2,3,4,5,7", "1,2,3,4,6,7", "1,2,3,5,6,7", "1,2,4,5,6,7"})
  public void secondPlaceTest(String numbers) {
    assertThat(WINNING_NUMBERS.getRank(buildLottoNumbers(numbers))).isEqualTo(SECOND);
  }

  @DisplayName("Test for Lotto which takes the third place")
  @ParameterizedTest
  @ValueSource(strings = {"1,2,3,4,5,8", "1,2,3,4,6,9", "1,2,3,5,6,8", "1,2,4,5,6,9"})
  public void thirdPlaceTest(String numbers) {
    assertThat(WINNING_NUMBERS.getRank(buildLottoNumbers(numbers))).isEqualTo(THIRD);
  }

  @DisplayName("Test for Lotto which takes the fourth place")
  @ParameterizedTest
  @ValueSource(strings = {"1,2,3,4,7,8", "1,2,3,4,8,9", "3,4,5,6,7,8", "3,4,5,6,8,9"})
  public void fourthPlaceTest(String numbers) {
    assertThat(WINNING_NUMBERS.getRank(buildLottoNumbers(numbers))).isEqualTo(FOURTH);
  }

  @DisplayName("Test for Lotto which takes the fifth place")
  @ParameterizedTest
  @ValueSource(strings = {"1,2,3,7,8,9", "1,2,3,8,9,10", "4,5,6,7,8,9", "4,5,6,8,9,10"})
  public void fifthPlaceTest(String numbers) {
    assertThat(WINNING_NUMBERS.getRank(buildLottoNumbers(numbers))).isEqualTo(FIFTH);
  }

  @DisplayName("Test for Lotto which fails to win")
  @ParameterizedTest
  @ValueSource(strings = {"1,2,7,8,9,10", "2,3,7,8,9,10", "7,8,9,10,11,12", "40,41,42,43,44,45"})
  public void failureTest(String numbers) {
    assertThat(WINNING_NUMBERS.getRank(buildLottoNumbers(numbers))).isEqualTo(FAILURE);
  }
}
