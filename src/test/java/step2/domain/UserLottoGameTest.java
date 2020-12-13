package step2.domain;

import org.junit.jupiter.api.Test;
import step2.LottoGame;

import static org.assertj.core.api.Assertions.assertThat;

public class UserLottoGameTest {
  @Test
  void constructorTest() {
    LottoGame game = new LottoGame(14000);
    assertThat(game.getCount()).isEqualTo(14);
  }
}
