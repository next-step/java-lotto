package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoMatchResultTest {

  @DisplayName("특정 개수만큼 일치하는 로또가 몇 개인지 센다")
  @ParameterizedTest
  @CsvSource({
      "6, 1",
      "5, 2",
      "4, 0",
      "3, 0"
  })
  void countMatches(int matchCount, int expected) {
    Map<Integer, Integer> resultMap = Map.of(
        6, 1,
        5, 2,
        4, 0
    );
    LottoMatchResult matchResult = new LottoMatchResult(resultMap);
    assertThat(matchResult.countMatches(matchCount)).isEqualTo(expected);
  }

}
