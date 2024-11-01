package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoFactoryTest {

    @Test
    void 로또_발행() {
        List<Lotto> lottos = LottoFactory.issueLottos(10000);

        assertThat(lottos).hasSize(10);
    }

    @Test
    void 로또_발행_음수_허용X() {

        assertThatThrownBy(() ->
                LottoFactory.issueLottos(-10000)
        ).isInstanceOf(IllegalArgumentException.class);

    }
}