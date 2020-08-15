package step2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class WinningTest {

  @Test
  void matchCountIsNone() {
    Winning winning = new Winning(Arrays.asList(40, 41, 42, 43, 44, 45), 7);

    assertThat(winning.matchCount(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))))
        .isEqualTo(0);
  }

  @Test
  void matchCountIsOne() {
    Winning winning = new Winning(Arrays.asList(1, 41, 42, 43, 44, 45), 7);

    assertThat(winning.matchCount(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))))
        .isEqualTo(1);
  }

  @Test
  void matchCountIsAll() {
    Winning winning = new Winning(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

    assertThat(winning.matchCount(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))))
        .isEqualTo(LottoRank.First.getMatchCount());
  }
}
