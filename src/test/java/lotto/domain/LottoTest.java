package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void 로또_개수_구하기() {
        Lottos lottos = Lottos.of(14000);
        assertThat(lottos.getLottoCount()).isEqualTo(14);
    }

    @Test
    void 로또_자동_생성() {
        Lottos lottos = Lottos.of(14000);
        assertThat(lottos).isEqualTo(Lottos.of(14000));
    }

}
