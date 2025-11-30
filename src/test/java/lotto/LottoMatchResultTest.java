package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
    LottoMatchResult matchResult = LottoMatchResult.of(6, 5, 5);
    LottoRank rank = LottoRank.of(matchCount);
    assertThat(matchResult.countMatches(rank)).isEqualTo(expected);
  }

  @DisplayName("총 당첨금을 계산한다")
  @Test
  void totalPrize() {
    LottoMatchResult matchResult = LottoMatchResult.of(6, 5, 5);
    assertThat(matchResult.totalPrize()).isEqualTo(2_000_000_000 + 1_500_000 * 2);
  }

}
