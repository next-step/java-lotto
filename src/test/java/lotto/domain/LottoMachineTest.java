package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

  @DisplayName("로또머신에서 로또생성 파라메터를 주입받아서 객체 생성 테스트.")
  @Test
  void 로또머신로또일급객체생성테스트() {

    Lotteries lotteries = LottoMachine.createLottos(1,
        Collections.singletonList("1,2,3,4,5,6"));

    assertThat(lotteries).isNotNull();
  }
}