package step2;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.LottoResult.*;


public class LottoMachineTest {

    @Test
    void 로또_머신은_돈_받은만큼_로또_생성() {
        LottoMachine lottoMachine = new LottoMachine(new LottoGenerator());
        List<Lotto> lottos = lottoMachine.buyLottos(5000);

        assertThat(lottos).hasSize(5);
    }

    @Test
    void 당첨금_계산() {
        LottoMachine lottoMachine = new LottoMachine(new LottoGenerator());

        Lotto winningLotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = List.of(
                Lotto.of(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.of(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.of(List.of(11, 2, 3, 4, 5, 6)),
                Lotto.of(List.of(11, 12, 3, 4, 5, 6)),
                Lotto.of(List.of(11, 12, 13, 14, 15, 16))
        );

        assertThat(lottoMachine.getLottoResults(lottos, winningLotto)).isEqualTo(
                Map.of(
                        FIRST, 2,
                        SECOND, 1,
                        THIRD, 1,
                        NONE, 1
                )
        );
    }
}
