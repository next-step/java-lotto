package step2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import step2.LottoStat.Grade;

public class WinningTest {

  @Test
  void sameNumberIsNone() {
    Winning winning = new Winning(Arrays.asList(40, 41, 42, 43, 44, 45));

    assertThat(winning.sameNumberCount(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))))
        .isEqualTo(0);
  }

  @Test
  void sameNumberIsOne() {
    Winning winning = new Winning(Arrays.asList(1, 41, 42, 43, 44, 45));

    assertThat(winning.sameNumberCount(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))))
        .isEqualTo(1);
  }

  @Test
  void isWinner() {
    Winning winning = new Winning(Arrays.asList(1, 2, 3, 4, 5, 6));

    assertThat(winning.sameNumberCount(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))))
        .isEqualTo(Grade.First.getSameCount());
  }
}
