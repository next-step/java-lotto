package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCountTest {

  @Test
  @DisplayName("생성 테스트")
  void create() {
    // given
    long lottoCount = 10;
    long manualCount = 4;

    // when
    // then
    assertThat(new LottoCount(lottoCount, manualCount)).isEqualTo(new LottoCount(lottoCount, manualCount));
  }
}
