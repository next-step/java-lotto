package lotto.domains;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    void 로또_갯수_테스트() {
        Lottos lottos = new Lottos(Arrays.asList(new Lotto(),new Lotto()));
        assertThat(lottos.count()).isEqualTo(2);
    }
}
