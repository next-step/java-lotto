package nextstep.lotto;

import static nextstep.lotto.LottoResult.FIRST_PLACE;
import static nextstep.lotto.LottoResult.FOURTH_PLACE;
import static nextstep.lotto.LottoResult.LOSE;
import static nextstep.lotto.LottoResult.SECOND_PLACE;
import static nextstep.lotto.LottoResult.THIRD_PLACE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest {

  @DisplayName("당첨 번호와 비교해서 등수를 결정한다.")
  @Test
  public void spec01() {
    final Lotto winning = new Lotto(1, 2, 3, 4, 5, 6);
    final Lotto firstLotto = new Lotto(1, 2, 3, 4, 5, 6);
    final Lotto secondLotto = new Lotto(1, 2, 3, 4, 5, 7);
    final Lotto thirdLotto = new Lotto(1, 2, 3, 4, 7, 8);
    final Lotto fourthLotto = new Lotto(1, 2, 3, 7, 8, 9);
    final Lotto loseLotto = new Lotto(7, 8, 9, 10, 11, 12);

    final LottoGame lottoGame = new LottoGame(winning);
    Assertions.assertAll(
      () -> assertThat(lottoGame.match(firstLotto)).isEqualTo(FIRST_PLACE),
      () -> assertThat(lottoGame.match(secondLotto)).isEqualTo(SECOND_PLACE),
      () -> assertThat(lottoGame.match(thirdLotto)).isEqualTo(THIRD_PLACE),
      () -> assertThat(lottoGame.match(fourthLotto)).isEqualTo(FOURTH_PLACE),
      () -> assertThat(lottoGame.match(loseLotto)).isEqualTo(LOSE)
    );
  }
}
