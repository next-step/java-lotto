package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

  @DisplayName("구입한 수만큼 로또를 발행한다")
  @Test
  void generateLottos() {
    List<Lotto> lottos = LottoGenerator.generateLottos(10);
    assertThat(lottos).hasSize(10);
  }
}
