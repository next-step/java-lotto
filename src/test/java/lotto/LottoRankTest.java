package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoRankTest {

  @DisplayName("LottoRank.of 는 당첨 규칙에 따라 올바른 등수를 반환한다")
  @ParameterizedTest
  @CsvSource({
      "6,false,FIRST",
      "5,true,SECOND",
      "5,false,THIRD",
      "4,false,FOURTH",
      "3,false,FIFTH",
      "2,false,MISS"
  })
  void lottoRankOfTest(int matchCount, boolean bonus, LottoRank expected) {
    assertThat(LottoRank.of(matchCount, bonus)).isEqualTo(expected);
  }

}
