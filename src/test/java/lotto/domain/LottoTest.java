package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    @Test
    void lotto() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5)))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Lotto number must be 6");
    }

    @Test
    void getSameCount() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int sameCount = lotto.getSameCount(Arrays.asList(1, 2, 3, 7, 8, 9));

        assertThat(sameCount).isEqualTo(3);
    }
}
