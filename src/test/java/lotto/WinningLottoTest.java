package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLottoTest {

  @Test
  void WinningLotto_생성_성공() {
    Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
    LottoNumber bonus = new LottoNumber(7);

    assertDoesNotThrow(() -> new WinningLotto(lotto, bonus));
  }

  @ParameterizedTest(name = "{0}는 이미 당첨번호이므로 실패함")
  @ValueSource(ints = {1, 2, 3, 4, 5, 6})
  void WinningLotto_생성_실패(int duplicatedNumber) {
    Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
    LottoNumber bonus = new LottoNumber(duplicatedNumber);

    assertThrows(IllegalArgumentException.class, () -> new WinningLotto(lotto, bonus));
  }

  @Test
  void matchedCount_성공() {
    Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
    LottoNumber bonus = new LottoNumber(7);
    WinningLotto winningLotto = new WinningLotto(lotto, bonus);

    assertThat(winningLotto.matchedCount(lotto)).isEqualTo(6);
  }

  @Test
  void matchedBonus_성공() {
    Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
    Lotto other = new Lotto(Set.of(1, 2, 3, 4, 5, 7));
    LottoNumber bonus = new LottoNumber(7);
    WinningLotto winningLotto = new WinningLotto(lotto, bonus);

    assertThat(winningLotto.matchedBonus(other)).isTrue();
  }

  @Test
  void matchedBonus_실패() {
    Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
    LottoNumber bonus = new LottoNumber(7);
    WinningLotto winningLotto = new WinningLotto(lotto, bonus);

    assertThat(winningLotto.matchedBonus(lotto)).isFalse();
  }
}
