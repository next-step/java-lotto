package lotto;

import lotto.domain.Lotto;
import lotto.domain.WinNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinNumbersTest {
    @Test
    @DisplayName("당첨 번호와 몇 개 일치하였는지 계산한다")
    public void matchCount() {
        Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        WinNumbers winNumbers = new WinNumbers(Set.of(1, 2, 3, 11, 12, 13), 14);
        assertThat(winNumbers.getMatchCount(lotto)).isEqualTo(3);
    }

    @Test
    @DisplayName("보너스 번호가 lotto에 포함되어 있다.")
    public void bonusIncludedIn_True() {
        Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        WinNumbers winNumbers = new WinNumbers(Set.of(1, 2, 3, 11, 12, 13), 4);
        assertThat(winNumbers.isBonusIncludedIn(lotto)).isTrue();
    }

    @Test
    @DisplayName("보너스 번호가 lotto에 포함되어있지 않다.")
    public void bonusIncludedIn_False() {
        Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        WinNumbers winNumbers = new WinNumbers(Set.of(1, 2, 3, 11, 12, 13), 14);
        assertThat(winNumbers.isBonusIncludedIn(lotto)).isFalse();
    }

    @Test
    @DisplayName("보너스 번호는 당첨번호와 일치할 수 없다")
    public void invalidBonus() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new WinNumbers(Set.of(1, 2, 3, 11, 12, 13), 13)
        );
    }
}
