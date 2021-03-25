package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoTest {

  Lotto thisWeekLotto;

  @BeforeEach
  void setUp() {
    thisWeekLotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
  }

  @Test
  @DisplayName("로또가 몇개가 일치하는지 확")
  public void containsCountTest() {
    Lotto lastWeekLotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
    assertEquals(6, lastWeekLotto.containsCount(thisWeekLotto));
  }

  @Test
  @DisplayName("로또에 해당 번호가 포함되는지 확인")
  public void contains() {
    assertEquals(true, thisWeekLotto.contains(new LottoNumber(5)));
  }

  @Test
  @DisplayName("로또가 6개 번호가 아닌 경우 확인")
  public static void validateCount() {
    assertThatIllegalArgumentException().isThrownBy(() -> {
      Lotto lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5));
    });
  }

}
