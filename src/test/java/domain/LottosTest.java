package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    void lottos() {
        Lottos lottos = new Lottos(1, () -> Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lottos.getValue()).hasSize(1);
    }
}
