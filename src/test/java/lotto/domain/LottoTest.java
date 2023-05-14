package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void create() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println(lotto.getNumbers());
    }

    @Test
    void matchedNumber_count() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int result = lotto.matchedNumber(Set.of(1, 2, 3, 4, 5, 7));
        assertThat(result).isEqualTo(5);
    }
}
