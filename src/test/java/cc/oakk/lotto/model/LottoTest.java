package cc.oakk.lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
}
