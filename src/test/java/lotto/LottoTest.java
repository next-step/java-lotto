package lotto;

import lotto.domain.Lotto;
import lotto.domain.WinNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    @Test
    @DisplayName("로또 번호는 1이상 45미만이어야 한다")
    public void invalidNumbers() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(Set.of(1, 2, 3, 4, 5, 46)));
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(Set.of(0, 1, 2, 3, 4, 5)));
    }

    @Test
    @DisplayName("당첨 번호는 6개여야 한다")
    public void invalidWinNumbersSize() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(Set.of(1, 2, 3, 4, 5)));
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(Set.of(1, 2, 3, 4, 5, 6, 7)));
    }

    @Test
    @DisplayName("당첨 번호와 몇 개 일치하였는지 계산한다")
    public void matchCount() {
        Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        WinNumbers winNumbers = new WinNumbers(Set.of(1, 2, 3, 11, 12, 13));
        assertThat(lotto.getMatchCount(winNumbers)).isEqualTo(3);
    }

    @Test
    @DisplayName("당첨 번호와 몇 개 일치하였는지 계산한다")
    public void contains() {
        Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.contains(6)).isTrue();
        assertThat(lotto.contains(7)).isFalse();
    }
}
