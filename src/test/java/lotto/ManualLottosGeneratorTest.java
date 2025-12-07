package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class ManualLottosGeneratorTest {

  @Test
  void generateManualLottos() {
    List<String> inputs = List.of("1,2,3,4,5,6", "7,8,9,10,11,12");
    assertThat(new ManualLottosGenerator(inputs).generate().count()).isEqualTo(2);
  }
}