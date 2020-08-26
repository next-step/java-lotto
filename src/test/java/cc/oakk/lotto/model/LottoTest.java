package cc.oakk.lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    @Test
    public void constructor_ShouldThrow_OnInvalidNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, Lotto.RANGE.getFrom() - 1)));
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, Lotto.RANGE.getTo() + 1)));
    }

    @Test
    public void constructor_ShouldThrow_OnDuplicatedNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 3, 5, 6)));
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 1, 5, 6)));
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
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.score(new Lotto(Arrays.asList(7, 8, 9, 10, 11,12)))).isEqualTo(Rank.NONE);
        assertThat(lotto.score(new Lotto(Arrays.asList(6, 7, 8, 9, 10, 11)))).isEqualTo(Rank.NONE);
        assertThat(lotto.score(new Lotto(Arrays.asList(5, 6, 7, 8, 9, 10)))).isEqualTo(Rank.FIFTH);
        assertThat(lotto.score(new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)))).isEqualTo(Rank.FOURTH);
        assertThat(lotto.score(new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8)))).isEqualTo(Rank.THIRD);
        assertThat(lotto.score(new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7)))).isEqualTo(Rank.SECOND);
        assertThat(lotto.score(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))).isEqualTo(Rank.FIRST);
    }
}
