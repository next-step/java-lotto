package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoTest {

  @Test
  @DisplayName("지난주 로또와 몇개가 일치하는지")
  public void containsCountTest() {
    LastWinningLotto lastWeekWinningLotto = LastWinningLotto.of(Arrays.asList(1, 2, 3, 4, 5, 6),4);
    Lotto lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
    assertEquals(6, lotto.containsCount(lastWeekWinningLotto));
  }
}
