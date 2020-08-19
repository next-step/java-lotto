package cc.oakk.lotto.model;

import cc.oakk.lotto.model.Lotto;
import cc.oakk.lotto.model.Rank;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    @Test
    public void constructor_ShouldThrow_OnInvalidNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.of(1, 2, 3, 4, 5, Lotto.MIN_NUMBER - 1));
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.of(1, 2, 3, 4, 5, Lotto.MAX_NUMBER + 1));
    }

    @Test
    public void constructor_ShouldThrow_OnInvalidNumberCount() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(IntStream.range(1, Lotto.NUMBER_COUNT).boxed().collect(Collectors.toList())));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(IntStream.range(1, Lotto.NUMBER_COUNT + 2).boxed().collect(Collectors.toList())));
    }

    @Test
    public void compare() {
        Lotto lotto = Lotto.of(1, 2, 3, 4, 5, 6);
        assertThat(lotto.compare(Lotto.of(7, 8, 9, 10, 11,12))).isEqualTo(Rank.NONE);
        assertThat(lotto.compare(Lotto.of(6, 7, 8, 9, 10, 11))).isEqualTo(Rank.NONE);
        assertThat(lotto.compare(Lotto.of(5, 6, 7, 8, 9, 10))).isEqualTo(Rank.FIFTH);
        assertThat(lotto.compare(Lotto.of(4, 5, 6, 7, 8, 9))).isEqualTo(Rank.FOURTH);
        assertThat(lotto.compare(Lotto.of(3, 4, 5, 6, 7, 8))).isEqualTo(Rank.THIRD);
        assertThat(lotto.compare(Lotto.of(2, 3, 4, 5, 6, 7))).isEqualTo(Rank.SECOND);
        assertThat(lotto.compare(Lotto.of(1, 2, 3, 4, 5, 6))).isEqualTo(Rank.FIRST);
    }
}
