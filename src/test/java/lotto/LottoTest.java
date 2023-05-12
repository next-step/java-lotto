package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoTest {
    @Test
    @DisplayName("당첨 번호는 6개여야 한다")
    public void invalidWinNumbersSize() {
        assertAll(
                () -> assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(Set.of(1, 2, 3, 4, 5))),
                () -> assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(Set.of(1, 2, 3, 4, 5, 6, 7)))
        );
    }

    @Test
    @DisplayName("몇 개 일치하였는지 계산한다")
    public void matchCount() {
        Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Set.of(1, 2, 3, 11, 12, 13));
        assertThat(lotto.getMatchCount(lotto2)).isEqualTo(3);
    }
}
