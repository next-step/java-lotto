package lotto.domains;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @Test
    void 생성자_테스트() {
        LottoMachine lottoMachine = new LottoMachine();
        assertThat(lottoMachine).isNotNull();
    }

    @Test
    void 구입금액_만큼_로또반환_테스트() {
        LottoMachine lottoMachine = new LottoMachine();
        Lottos lottos = lottoMachine.buyLottos(new Cash(14000));
        assertThat(lottos.count()).isEqualTo(14);
    }
}
