package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoFactoryTest {

  @Test
  @DisplayName("로또를 만들어주는 테스트를 진행한다.")
  void lottoGenerate() {
    assertThat(new LottoFactory().apply()).hasSize(6);
  }
}
