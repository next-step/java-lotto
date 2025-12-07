package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {

  @DisplayName("자동 로또를 1개 발행한다")
  @Test
  void randomLotto() {
    assertThat(LottoMachine.randomLotto().numbers()).hasSize(6);
  }
}
