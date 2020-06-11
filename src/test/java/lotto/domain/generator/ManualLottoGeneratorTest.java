package lotto.domain.generator;

import lotto.domain.data.LottoNumberPool;
import lotto.domain.data.Lotto;
import lotto.domain.data.ManualLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ManualLottoGeneratorTest {

    @DisplayName("수동번호 메모대로 lotto 가 생성된다,")
    @Test
    public void generatorTest() {
        List<Integer> lottoMemo1 = List.of(1,2,3,4,5,6);
        List<Integer> lottoMemo2 = List.of(1,2,3,7,5,8);
        List<ManualLotto> manualLottos = ManualLotto.list(List.of(lottoMemo1, lottoMemo2));

        List<Lotto> lottos = ManualLottoGenerator.generate(manualLottos);
        assertThat(lottos.size()).isEqualTo(2);
        assertThat(lottos).contains(
                Lotto.of(LottoNumberPool.get(lottoMemo1)),
                Lotto.of(LottoNumberPool.get(lottoMemo2)));
    }

    @DisplayName("수동번호를 메모를 전달하지 않을 경우 빈 List가 전달된다.")
    @Test
    public void generatorNullTest() {
        List<Lotto> lottos = ManualLottoGenerator.generate(null);

        assertThat(lottos.size()).isEqualTo(0);
        assertThat(lottos).isEmpty();
    }

    @DisplayName("수동번호가 없는 빈 메모를 전달하면 빈 List<Lotto>가 전달된다.")
    @Test
    public void generatorEmptyTest() {
        List<Lotto> lottos = ManualLottoGenerator.generate(ManualLotto.list(new ArrayList<>()));

        assertThat(lottos.size()).isEqualTo(0);
        assertThat(lottos).isEmpty();
    }

}