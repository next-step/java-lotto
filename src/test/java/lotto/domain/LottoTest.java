package lotto.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void match_1등() {
        Lotto userLotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        int result = userLotto.match(winningLotto);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void match_3등() {
        Lotto userLotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 7));

        int result = userLotto.match(winningLotto);

        assertThat(result).isEqualTo(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void of_중복_값() {
        Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 5));
    }
}
