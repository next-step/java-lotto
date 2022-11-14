package nextstep.lotto;

import static nextstep.lotto.LottoFactory.createLotto;
import static nextstep.lotto.domain.LottoNumber.lottoNumber;
import static nextstep.lotto.domain.LottoResult.FIRST_PLACE;
import static nextstep.lotto.domain.LottoResult.FOURTH_PLACE;
import static nextstep.lotto.domain.LottoResult.LOSE;
import static nextstep.lotto.domain.LottoResult.SECOND_PLACE;
import static nextstep.lotto.domain.LottoResult.THIRD_PLACE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import nextstep.lotto.domain.Lotto;
import nextstep.lotto.domain.LottoGame;
import nextstep.lotto.domain.LottoNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest {

  @DisplayName("당첨 번호와 비교해서 등수를 결정한다.")
  @Test
  public void spec01() {
    final Set<LottoNumber> winningNumbers = Set.of(lottoNumber(1), lottoNumber(1), lottoNumber(1), lottoNumber(1), lottoNumber(1));
    final Lotto firstLotto = createLotto(1, 2, 3, 4, 5, 6);
    final Lotto secondLotto = createLotto(1, 2, 3, 4, 5, 7);
    final Lotto thirdLotto = createLotto(1, 2, 3, 4, 7, 8);
    final Lotto fourthLotto = createLotto(1, 2, 3, 7, 8, 9);
    final Lotto loseLotto = createLotto(7, 8, 9, 10, 11, 12);

    final LottoGame lottoGame = new LottoGame(winningNumbers);
    Assertions.assertAll(
      () -> assertThat(lottoGame.match(firstLotto)).isEqualTo(FIRST_PLACE),
      () -> assertThat(lottoGame.match(secondLotto)).isEqualTo(SECOND_PLACE),
      () -> assertThat(lottoGame.match(thirdLotto)).isEqualTo(THIRD_PLACE),
      () -> assertThat(lottoGame.match(fourthLotto)).isEqualTo(FOURTH_PLACE),
      () -> assertThat(lottoGame.match(loseLotto)).isEqualTo(LOSE)
    );
  }
}
