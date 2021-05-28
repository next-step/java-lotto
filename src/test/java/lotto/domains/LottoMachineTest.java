package lotto.domains;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @Test
    void 구입금액_만큼_로또반환_테스트() {
        Lottos lottos = LottoMachine.makeLottos(new Cash(14000));
        assertThat(lottos.count()).isEqualTo(14);
    }
}
