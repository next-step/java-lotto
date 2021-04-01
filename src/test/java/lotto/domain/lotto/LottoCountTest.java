package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCountTest {

  @Test
  @DisplayName("생성 테스트")
  void create() {
    assertThat(new LottoCount(10)).isEqualTo(new LottoCount(10));
  }
}
