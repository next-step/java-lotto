package lotto.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    void 로또리스트는_로또리스_프로퍼티를_갖는다(){
        Lottos lottos = new Lottos();
        assertThat(lottos).hasFieldOrProperty("lottos");
    }
}
