package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.domain.LottoRanking.NONE;
import static lotto.domain.LottoRanking.confirmRanking;
import static org.assertj.core.api.Assertions.assertThat;

class LottoRankingTest {

  @DisplayName("정해진 등수가 있는 숫자를 입력하면 등수를 나타내는 enum 반환")
  @ParameterizedTest
  @ValueSource(ints = {3, 4, 5, 6})
  void testMatchedRanking(int givenMatchCount) {
    assertThat(confirmRanking(givenMatchCount)).isNotSameAs(NONE);
  }

  @DisplayName("정해진 등수가 없는 숫자를 입력하면 NONE 반환")
  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 7})
  void testNoneMatchedRanking(int givenMatchCount) {
    assertThat(confirmRanking(givenMatchCount)).isSameAs(NONE);
  }

}
