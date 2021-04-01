package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMatchTest {

  @Test
  @DisplayName("생성 테스트")
  void create() {
    int matchCount = 3;
    boolean isBonusNumberMatch = false;
    assertThat(new LottoMatch(matchCount, isBonusNumberMatch))
        .isEqualTo(new LottoMatch(matchCount, isBonusNumberMatch));
  }
}
