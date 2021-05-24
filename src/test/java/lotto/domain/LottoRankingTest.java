package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.domain.LottoRanking.NONE;
import static lotto.domain.LottoRanking.confirm;
import static org.assertj.core.api.Assertions.assertThat;

class LottoRankingTest {

  @DisplayName("당첨번호에 포함된 숫자의 갯수를 입력하면 등수를 반환한다.")
  @ParameterizedTest
  @ValueSource(ints = {3, 4, 5, 6})
  void testMatchedRanking(int givenMatchCount) {
    assertThat(confirm(givenMatchCount)).isNotSameAs(NONE);
  }

  @DisplayName("당첨번호를 하나도 맞추지 못했거나, 등수가 없는 갯수를 맞췄으면 의미 없는 등수를 반환한다.")
  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 7})
  void testNoneMatchedRanking(int givenMatchCount) {
    assertThat(confirm(givenMatchCount)).isSameAs(NONE);
  }

}
