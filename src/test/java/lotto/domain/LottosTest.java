package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    void 로또들을_저장할_수_있다() {
        // given
        Lottos lottos = new Lottos();

        // when
        lottos.storeLotto(new Lotto());
        lottos.storeLotto(new Lotto());
        lottos.storeLotto(new Lotto());

        // then
        assertThat(lottos.getLottos().size()).isEqualTo(3);
    }

}
