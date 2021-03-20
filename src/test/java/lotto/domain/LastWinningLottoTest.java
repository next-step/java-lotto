package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LastWinningLottoTest {
  @Test
  @DisplayName("현재 로또가 몇등으로 당첨되는지 확인")
  public void match() {
    LastWinningLotto lastWinningLotto = LastWinningLotto.of(Arrays.asList(1, 2, 3, 4, 5, 6), 4);
    Lotto thisWeekLotto = Lotto.of(Arrays.asList(1,2,3,4,5,6));
    assertEquals(LottoRank.FIRST,lastWinningLotto.match(thisWeekLotto));

  }
}
