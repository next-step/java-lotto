package lotto.domain;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {

    @Test
    void valid() {
        assertThatThrownBy(() -> new LottoNumbers(new Integer[]{0, 2, 3}))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new LottoNumbers(new Integer[]{46, 2, 3, 4, 5, 0}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void contains() {
        LottoNumbers numbers = new LottoNumbers(Arrays.array(1, 2, 3, 4, 5, 6));
        assertThat(numbers.contains(1)).isTrue();
    }

    @Test
    void matchingNumbers() {
        LottoNumbers numbers = new LottoNumbers(Arrays.array(1, 2, 3, 4, 5, 6));
        LottoNumbers luckNumbers = new LottoNumbers(Arrays.array(1, 2, 3, 4, 5, 7));
        int matchingCount = numbers.matchingNumbers(new Lotto(luckNumbers));
        assertThat(matchingCount).isEqualTo(5);
    }

}
