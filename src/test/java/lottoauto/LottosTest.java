package lottoauto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @Test
    void Lotts_구입금액만큼_발급() {
        Lottos lottos = Lottos.from(14000);
        System.out.println(lottos);
        assertThat(lottos.size()).isEqualTo(14);
    }
}