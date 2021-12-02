package lotto;

import lotto.domain.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @Test
    void 구매_개수만큼_로또_반환() {
        Lottos lottos = new Lottos(6);
        Assertions.assertThat(lottos.getLottos().size()).isEqualTo(6);
    }
}
