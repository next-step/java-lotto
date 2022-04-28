package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Set;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

  @Test
  void createDuplicateBonus() {
    assertThatThrownBy(() -> WinningLotto.create(Set.of(1, 2, 3, 4, 5, 6), 6))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void matchBonus() {
    WinningLotto winningLotto = WinningLotto.create(Set.of(1, 2, 3, 4, 5, 6), 7);
    Lotto lotto = Lotto.create(Set.of(1, 2, 3, 4, 5, 7));
    assertThat(winningLotto.matchBonus(lotto)).isTrue();
  }
}
