package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoDrawResultTest {

  @ParameterizedTest
  @DisplayName("로또 추첨 결과가 잘 생성되는지 확인")
  @CsvSource(value = {"1|100|true", "2|500|false", "0|700|true", "4|0|false"}, delimiter = '|')
  void generate(int matchCount, int reword, boolean bonusMatch) {
    LottoDrawResult lottoDrawResult = new LottoDrawResult(matchCount, reword, bonusMatch);
    assertThat(lottoDrawResult).usingRecursiveComparison()
        .isEqualTo(new LottoDrawResult(matchCount, reword, bonusMatch));

  }
}