package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoFactoryTest {

  @Test
  @DisplayName("로또 번호 생성")
  void create() {
    assertThat(LottoFactory.create()).hasSize(6);
  }
}