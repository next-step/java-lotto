package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.FixedDrawingStrategy;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

class RandomDrawingStrategyTest {

  @Test
  void 로또번호_생성() {
    Lotto lotto = new Lotto(new FixedDrawingStrategy(List.of(1, 2, 3, 4, 5, 6)));

    assertThat(lotto.getLottoNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
  }
}