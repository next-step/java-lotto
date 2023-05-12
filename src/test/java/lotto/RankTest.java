package lotto;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    @DisplayName("몇 등인지 계산한다")
    public void rank() {
        Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        WinNumbers winNumbers = new WinNumbers(Set.of(1, 2, 3, 4, 5, 7), 8);
        assertThat(Rank.of(lotto, winNumbers).getPrize()).isEqualTo(1500000);
    }
}
