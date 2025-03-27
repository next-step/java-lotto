package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.Test;

class LottoTest {

  @Test
  void 당첨_로또와_생성_로또_비교() {
    Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
    WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));

    assertThat(winningLotto.matchingWinningNumber(lotto1)).isEqualTo(6);
    assertThat(winningLotto.matchingWinningNumber(lotto2)).isEqualTo(5);
  }
}