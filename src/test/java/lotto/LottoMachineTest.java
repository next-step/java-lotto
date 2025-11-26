package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {

  @DisplayName("구입 금액만큼 로또를 발행한다")
  @Test
  void generateLottos() {
    List<Lotto> lottos = LottoMachine.generateLottos(1);
    assertThat(lottos).hasSize(1);
  }
}
