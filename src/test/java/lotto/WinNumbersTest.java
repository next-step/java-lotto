package lotto;

import lotto.domain.Lotto;
import lotto.domain.WinNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class WinNumbersTest {
    @Test
    @DisplayName("당첨 번호와 몇 개 일치하였는지 계산한다")
    public void matchCount() {
        Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        WinNumbers winNumbers = new WinNumbers(Set.of(1, 2, 3, 11, 12, 13));
        assertThat(winNumbers.getMatchCount(lotto)).isEqualTo(3);
    }
}
