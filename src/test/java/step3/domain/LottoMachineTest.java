package step3.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoMachineTest {

    @Test
    void 가격만큼_로또_생성() {
        Lottos lottos = LottoMachine.buyLottoAutomatically(14000);
        assertThat(lottos.getLottos()).hasSize(14);
    }

    @Test
    void 문자열로_로또_생성() {
        Lotto lotto = LottoMachine.createLotto("1,2,3,4,5,6");
        assertThat(lotto).isEqualTo(Lotto.of(1,2,3,4,5,6));
    }

    @Test
    void 로또_합치기() {
        Lottos lottos1 = LottoMachine.buyLottoAutomatically(2000);
        Lottos lottos2 = LottoMachine.buyLottoAutomatically(3000);

        Lottos mergedLottos = LottoMachine.mergeLotto(lottos1, lottos2);

        assertThat(mergedLottos.getLottos()).hasSize(5);
        assertThat(mergedLottos.getLottos())
                .containsAll(lottos1.getLottos())
                .containsAll(lottos2.getLottos());
    }
}
