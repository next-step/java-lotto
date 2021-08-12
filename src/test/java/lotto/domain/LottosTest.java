package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @DisplayName("로또 2개 구입")
    @Test
    void create() {
        Lotto one = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto two = new Lotto(Arrays.asList(7, 8, 9, 10, 12, 13));

        assertThat(new Lottos(Arrays.asList(one, two)).getValue())
                .contains(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        new Lotto(Arrays.asList(7, 8, 9, 10, 12, 13)));
    }

}