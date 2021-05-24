package study.step2.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ManualLottosTest {

  @DisplayName("수동 로또 생성 테스트")
  @Test
  void createManualLottos() {
    // given
    String inputText = "8, 21, 23, 41, 42, 43";

    // when
    ManualLottos manualLottos = new ManualLottos(Collections.singletonList(inputText));

    // then
    assertThat(manualLottos).isEqualTo(new ManualLottos(Collections.singletonList(inputText)));
  }

  @DisplayName("수동 로또 생성 번호 갯수가 적을 때 실패하는지 테스트")
  @Test
  void createManualLottosFail() {
    // given
    String inputText = "8, 21, 23, 41, 42";

    // when
    Throwable thrown = catchThrowable(() -> new ManualLottos(Arrays.asList(inputText)));

    //then
    assertThat(thrown).isInstanceOf(RuntimeException.class);
  }

  @DisplayName("수동 로또 번호가 음수 일 때실패하는지 테스트")
  @Test
  void createManualLottosFailWithNotPositiveNumber() {
    // given
    String inputText = "8, 21, 23, 41, 42, -43";

    // when
    Throwable thrown = catchThrowable(() -> new ManualLottos(Arrays.asList(inputText)));

    //then
    assertThat(thrown).isInstanceOf(RuntimeException.class);
  }

}
