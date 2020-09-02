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
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, LottoNumber.RANGE.getFrom() - 1)));
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, LottoNumber.RANGE.getTo() + 1)));
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
    public void getMatchingCount() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getMatchingCount(new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7)))).isEqualTo(5);
        assertThat(lotto.getMatchingCount(new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8)))).isEqualTo(4);
        assertThat(lotto.getMatchingCount(new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)))).isEqualTo(3);
        assertThat(lotto.getMatchingCount(new Lotto(Arrays.asList(5, 6, 7, 8, 9, 10)))).isEqualTo(2);
    }

    @Test
    public void contains() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.contains(LottoNumber.of(1))).isEqualTo(true);
        assertThat(lotto.contains(LottoNumber.of(2))).isEqualTo(true);
        assertThat(lotto.contains(LottoNumber.of(3))).isEqualTo(true);
        assertThat(lotto.contains(LottoNumber.of(4))).isEqualTo(true);
        assertThat(lotto.contains(LottoNumber.of(5))).isEqualTo(true);
        assertThat(lotto.contains(LottoNumber.of(6))).isEqualTo(true);

        assertThat(lotto.contains(LottoNumber.of(7))).isEqualTo(false);
        assertThat(lotto.contains(LottoNumber.of(8))).isEqualTo(false);
        assertThat(lotto.contains(LottoNumber.of(9))).isEqualTo(false);
        assertThat(lotto.contains(LottoNumber.of(10))).isEqualTo(false);
        assertThat(lotto.contains(LottoNumber.of(11))).isEqualTo(false);
    }
}
