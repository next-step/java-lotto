package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoNumberListTest {

  @Test
  @DisplayName("지난주 로또에 이번 주 로또가 얼마나 포함되는지")
  public void containsCount() {
    LottoNumberList lottoNumberList= LottoNumberList.of(Arrays.asList(1,2,3,4,5,6));
    Lotto lastWeekLotto = Lotto.of(Arrays.asList(1,2,3,4,5,6));
    assertEquals(6,lottoNumberList.containsCount(lastWeekLotto));
  }

}
