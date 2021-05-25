package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.domain.LottoRanking.NONE;
import static lotto.domain.LottoRanking.confirm;
import static org.assertj.core.api.Assertions.assertThat;

class LottoRankingTest {

  @DisplayName("당첨 번호를 맞춘 숫자 갯수를 입력하면 등수를 반환한다.")
  @ParameterizedTest
  @CsvSource(value = {"3,FIFTH", "4,FOURTH", "5,THIRD", "6,FIRST"})
  void testMatchedRankingNonWithBonusNumberMatched(int givenMatchCount, LottoRanking expectation) {
    //given
    boolean givenBonusNumberMatched = false;

    assertThat(confirm(givenMatchCount, givenBonusNumberMatched)).isSameAs(expectation);
  }

  @DisplayName("당첨 번호를 맞춘 숫자 갯수가 5개이고 보너스 번호를 맞췄으면 2등이다. 당첨 번호를 맞춘 숫자 갯수가 5개 일때만 보너스 번호를 맞춘 것이 영향이 있다.")
  @ParameterizedTest
  @CsvSource(value = {"3,FIFTH", "4,FOURTH", "5,SECOND", "6,FIRST"})
  void testMatchedRankingWithBonusNumberMatched(int givenMatchCount, LottoRanking expectation) {
    //given
    boolean givenBonusNumberMatched = true;

    assertThat(confirm(givenMatchCount, givenBonusNumberMatched)).isSameAs(expectation);
  }

  @DisplayName("당첨번호를 하나도 맞추지 못했거나, 등수가 없는 갯수를 맞췄으면 의미 없는 등수를 반환한다. 보너스 번호를 맞춘 여부와는 상관이 없다.")
  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 7})
  void testNoneMatchedRanking(int givenMatchCount) {
    //given
    boolean givenBonusNumberMatched = true;

    assertThat(confirm(givenMatchCount, givenBonusNumberMatched)).isSameAs(NONE);
  }

}
