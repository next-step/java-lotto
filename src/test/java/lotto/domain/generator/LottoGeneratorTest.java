package lotto.domain.generator;

import lotto.domain.data.Lotto;
import lotto.domain.data.LottoNumberPool;
import lotto.domain.data.ManualLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @DisplayName("입력한 수대로 Lotto 가 생성된다.")
    @Test
    void generateTest() {
        List<Integer> lottoMemo1 = List.of(1,2,3,4,5,6);
        List<Integer> lottoMemo2 = List.of(1,2,3,7,5,8);
        List<ManualLotto> manualLottos = ManualLotto.list(List.of(lottoMemo1, lottoMemo2));

        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> lottos = lottoGenerator.generate(2, manualLottos);


        assertThat(lottos.size()).isEqualTo(4);
        assertThat(lottos).contains(
                Lotto.of(LottoNumberPool.get(lottoMemo1)),
                Lotto.of(LottoNumberPool.get(lottoMemo2)));

    }
}
