package lotto.domain;

import static lotto.domain.LottoGame.LOTTO_NO_COUNT;
import static lotto.domain.LottoNo.LOWER_BOUND;
import static lotto.domain.LottoNo.UPPER_BOUND;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoGameTest {

  private static final String DELIMITER = ",";

  @DisplayName("Test for illegal argument")
  @ParameterizedTest
  @ValueSource(strings = {"1,1,2,3,4,5", "1,2,3,4,5", "1,2,3,4,5,6,7", "0,1,2,3,4,5", "1,2,3,4,5,46"})
  public void IllegalArgumentTest(String numbers) {
    Set<Integer> integers = Arrays.stream(numbers.split(DELIMITER))
        .map(Integer::parseInt)
        .collect(Collectors.toSet());

    assertThatThrownBy(() -> new LottoGame(integers))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("Test for random generation method")
  @Test
  public void randomGenerationTest() {
    Set<Integer> integers = LottoGame.genarateRandomNumbers();
    assertThat(integers).hasSize(LOTTO_NO_COUNT);
    integers.forEach(integer -> assertThat(integer).isBetween(LOWER_BOUND, UPPER_BOUND));
  }
}

