package step3.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoMachineTest {

    @Test
    void 가격만큼_로또_생성() {
        Lottos lottos = LottoMachine.buyLotto(14000);
        assertThat(lottos.getLottos()).hasSize(14);
    }

    @Test
    void 문자열로_로또_생성() {
        Lotto lotto = LottoMachine.createLotto("1,2,3,4,5,6");
        assertThat(lotto).isEqualTo(Lotto.of(1,2,3,4,5,6));
    }
}
