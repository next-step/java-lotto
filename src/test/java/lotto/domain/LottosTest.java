package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    void 로또들을_저장할_수_있다() {
        // given
        final Lottos lottos = new Lottos(new ArrayList<>());

        // when
        lottos.storeLotto(Lotto.autoLotto());
        lottos.storeLotto(Lotto.autoLotto());
        lottos.storeLotto(Lotto.autoLotto());

        // then
        assertThat(lottos.getLottos().size()).isEqualTo(3);
    }

}
