package cc.oakk.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    @Test
    public void constructor_ShouldThrow_OnBelowZero() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(1, 2, 3, 4, 5, -1));
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(1, 2, 3, 4, 5, 0));
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(1, 2, 3, 4, 5, Integer.MIN_VALUE));
    }

    @Test
    public void compare() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        assertThat(lotto.compare(new Lotto(7, 8, 9, 10, 11,12))).isEqualTo(Rank.SEVENTH);
        assertThat(lotto.compare(new Lotto(6, 7, 8, 9, 10, 11))).isEqualTo(Rank.SIXTH);
        assertThat(lotto.compare(new Lotto(5, 6, 7, 8, 9, 10))).isEqualTo(Rank.FIFTH);
        assertThat(lotto.compare(new Lotto(4, 5, 6, 7, 8, 9))).isEqualTo(Rank.FOURTH);
        assertThat(lotto.compare(new Lotto(3, 4, 5, 6, 7, 8))).isEqualTo(Rank.THIRD);
        assertThat(lotto.compare(new Lotto(2, 3, 4, 5, 6, 7))).isEqualTo(Rank.SECOND);
        assertThat(lotto.compare(new Lotto(1, 2, 3, 4, 5, 6))).isEqualTo(Rank.FIRST);
    }
}
