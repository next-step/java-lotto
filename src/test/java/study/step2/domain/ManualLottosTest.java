package study.step2.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ManualLottosTest {

  @DisplayName("수동 로또 생성 테스트")
  @Test
  void createManualLottos() {
    // given
    String inputText = "8, 21, 23, 41, 42, 43";

    // when
    ManualLottos manualLottos = new ManualLottos(Arrays.asList(inputText));

    // then
    assertThat(manualLottos).isEqualTo(new ManualLottos(Arrays.asList(inputText)));
  }

}
