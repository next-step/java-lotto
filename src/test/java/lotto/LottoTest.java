package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

class LottoTest {

  @Test
  void 당첨_로또와_생성_로또_비교() {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
    Lotto lotto = new Lotto(numbers);
    List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
    assertThat(lotto.confirmWinning(winningNumbers)).isEqualTo(6);
  }
}