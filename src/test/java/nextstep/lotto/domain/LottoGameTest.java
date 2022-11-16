package nextstep.lotto.domain;

import static nextstep.lotto.domain.LottoFactory.createLotto;
import static nextstep.lotto.domain.LottoNumber.lottoNumber;
import static nextstep.lotto.domain.LottoResult.FIRST_PLACE;
import static nextstep.lotto.domain.LottoResult.FOURTH_PLACE;
import static nextstep.lotto.domain.LottoResult.LOSE;
import static nextstep.lotto.domain.LottoResult.SECOND_PLACE;
import static nextstep.lotto.domain.LottoResult.THIRD_PLACE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest {

  @DisplayName("당첨 번호와 비교해서 등수를 결정한다.")
  @Test
  public void spec01() {
    final Set<LottoNumber> winningNumbers = Set.of(lottoNumber(1), lottoNumber(2), lottoNumber(3), lottoNumber(4), lottoNumber(5), lottoNumber(6));
    final Lotto firstLotto = createLotto(1, 2, 3, 4, 5, 6);
    final Lotto secondLotto = createLotto(1, 2, 3, 4, 5, 7);
    final Lotto thirdLotto = createLotto(1, 2, 3, 4, 7, 8);
    final Lotto fourthLotto = createLotto(1, 2, 3, 7, 8, 9);
    final Lotto loseLotto = createLotto(7, 8, 9, 10, 11, 12);

    final LottoGame lottoGame = new LottoGame(winningNumbers, LottoNumber.lottoNumber(10));
    assertThat(
      lottoGame.match(
        List.of(firstLotto, secondLotto, thirdLotto, fourthLotto, loseLotto))
    ).containsExactly(FIRST_PLACE, SECOND_PLACE, THIRD_PLACE, FOURTH_PLACE, LOSE);
  }
}
