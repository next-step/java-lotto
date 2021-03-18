package lotto.domain;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LastWinningLottoTest {

  @Test
  @DisplayName("지난 주 당첨 로또, 보너스 볼 발급")
  public void createLastWinningLotto() {
    LastWinningLotto lastWinningLotto = LastWinningLotto.of(Arrays.asList(1,2,3,4,5,6),4);
  }
}
