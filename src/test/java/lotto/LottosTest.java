package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottosTest {

  @DisplayName("당첨 통계를 계산한다")
  @ParameterizedTest
  @CsvSource({
      "6, 1",
      "5, 1",
      "0, 1",
      "4, 0",
      "3, 0"
  })
  void matchResult(int matchCount, int expectedCount) {
    Lottos lottos = new Lottos(List.of(
        new Lotto(1, 2, 3, 4, 5, 6),
        new Lotto(1, 2, 3, 4, 5, 7),
        new Lotto(7, 8, 9, 10, 11, 12)));
    Lotto winningNumbers = new Lotto(1, 2, 3, 4, 5, 6);
    LottoMatchResult result = lottos.matchResult(
        new WinningNumbers(winningNumbers, new LottoNumber(15)));
    LottoRank rank = LottoRank.of(matchCount, false);
    assertThat(result.countMatches(rank)).isEqualTo(expectedCount);
  }

}
