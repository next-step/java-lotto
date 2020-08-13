package step2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class WinningTest {

  @Test
  void isWinner() {
    Winning winning = new Winning(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

    assertThat(winning.isWinner(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))).isTrue();
  }

  @Test
  void isNotWinner() {
    Winning winning = new Winning(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));

    assertThat(winning.isWinner(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))).isFalse();
  }
}
