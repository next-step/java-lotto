package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    void create() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lotto).isEqualTo(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }
}
