package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

  @DisplayName("로또를 구매한다.")
  @Test
  void buyLottos() {
    // given
    LottoService lottoService = new LottoService();
    int money = 5000;

    // when
    List<Lotto> lottos = lottoService.buyLottos(money);

    // then
    assertThat(lottos).hasSize(5);
  }

  @DisplayName("당첨 결과를 계산한다.")
  @Test
  void calculateResult() {
    // given
    LottoService lottoService = new LottoService();

    Lotto lotto1 = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)); // 6개 일치 (1등)
    Lotto lotto2 = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 7)); // 5개 일치, 보너스 O (2등)
    Lotto lotto3 = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 8)); // 5개 일치, 보너스 X (3등)
    Lotto lotto4 = Lotto.of(Arrays.asList(1, 2, 3, 4, 9, 10)); // 4개 일치 (4등)
    Lotto lotto5 = Lotto.of(Arrays.asList(1, 2, 3, 11, 12, 13)); // 3개 일치 (5등)
    Lotto lotto6 = Lotto.of(Arrays.asList(1, 2, 14, 15, 16, 17)); // 2개 일치 (꽝)

    List<Lotto> lottos = Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6);

    Lotto winningLotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
    LottoNumber bonusNumber = new LottoNumber(7);

    // when
    LottoResult lottoResult = lottoService.calculateResult(lottos, winningLotto, bonusNumber);

    // then
    assertThat(lottoResult.getRankCount(Rank.FIRST)).isEqualTo(1);
    assertThat(lottoResult.getRankCount(Rank.SECOND)).isEqualTo(1);
    assertThat(lottoResult.getRankCount(Rank.THIRD)).isEqualTo(1);
    assertThat(lottoResult.getRankCount(Rank.FOURTH)).isEqualTo(1);
    assertThat(lottoResult.getRankCount(Rank.FIFTH)).isEqualTo(1);
    assertThat(lottoResult.getRankCount(Rank.MISS)).isEqualTo(1);
  }
}
