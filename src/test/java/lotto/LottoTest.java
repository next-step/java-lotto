package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
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

    @Test
    @DisplayName("특정 번호의 공을 포함하고 있는지 확인한다")
    public void contains() {
        Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        assertAll(
                () -> assertThat(lotto.contains(LottoNumber.of(6))).isTrue(),
                () -> assertThat(lotto.contains(LottoNumber.of(7))).isFalse()
        );
    }
}
