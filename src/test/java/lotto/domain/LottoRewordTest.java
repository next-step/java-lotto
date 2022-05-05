package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoRewordTest {

  @ParameterizedTest
  @DisplayName("매칭된 숫자 개수에 따라 리워드가 잘 가져와지는지 확인")
  @CsvSource(value = {"0|NO_REWORD", "1|NO_REWORD", "2|NO_REWORD", "3|FIFTH", "4|FOURTH", "5|THIRD",
      "6|FIRST"}, delimiter = '|')
  void winMoney(int matchCount, LottoReword reword) {
    assertThat(LottoReword.getReword(matchCount, false)).isEqualTo(reword);
  }

  @ParameterizedTest
  @DisplayName("보너스 번호 상금이 가져와지는지 확인")
  @CsvSource(value = {"5|true|SECOND", "5|false|THIRD"}, delimiter = '|')
  void winMoney(int matchCount, boolean bonusMatch, LottoReword reword) {
    assertThat(LottoReword.getReword(matchCount, bonusMatch)).isEqualTo(reword);
  }

}