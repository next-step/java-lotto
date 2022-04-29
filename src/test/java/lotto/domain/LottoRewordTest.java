package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoRewordTest {

  @ParameterizedTest
  @DisplayName("매칭된 숫자 개수에 따라 상금이 가져와지는지 확인")
  @CsvSource(value = {"0|0", "1|0", "2|0", "3|5000", "4|50000", "5|1500000",
      "6|2000000000"}, delimiter = '|')
  void winMoney(int matchCount, int reword) {
    assertThat(LottoReword.getWinMoney(matchCount)).isEqualTo(reword);
  }

  @ParameterizedTest
  @DisplayName("상금이 정의되지 않았을 시 에러 발생")
  @ValueSource(ints = {10, 100, 200})
  void noReword(int matchCount) {
    assertThatThrownBy(
        () -> {
          LottoReword.getWinMoney(matchCount);
        });
  }
}