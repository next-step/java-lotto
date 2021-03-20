package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoTest {

  @Test
  @DisplayName("로또가 몇개가 일치하는지 확")
  public void containsCountTest() {
    Lotto thisWeekLotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
    Lotto lastWeekLotto = Lotto.of(Arrays.asList(1,2,3,4,5,6));
    assertEquals(6,lastWeekLotto.containsCount(thisWeekLotto));
  }

  @Test
  @DisplayName("로또에 해당 번호가 포함되는지 확인")
  public void contains() {
    Lotto thisWeekLotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
    assertEquals(true,thisWeekLotto.contains(new LottoNumber(5)));
  }
}
