package lottogame.model.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class ManualLottosTest {

    @Test
    void 수동로또_갯수를_반환_할_수_있다() {
        List<Set<Integer>> manualList = List.of(
                Set.of(1,2,3,4,5,6),
                Set.of(2,3,4,5,6,7)
        );

        assertThat(
                new ManualLottos(manualList).size()
        ).isEqualTo(2);
    }

    @Test
    void 수동로또번호묶음중_인덱스에_알맞은_번호묶음을_반환_할_수_있다() {
        List<Set<Integer>> manualList = List.of(
                Set.of(1,2,3,4,5,6),
                Set.of(2,3,4,5,6,7)
        );

        ManualLottos manualLottos = new ManualLottos(manualList);

        assertThat(
                manualLottos.findManualLottoByIdx(0)
        ).contains(1,2,3,4,5,6);

        assertThat(
                manualLottos.findManualLottoByIdx(1)
        ).contains(2,3,4,5,6,7);
    }

    @Test
    void 수동로또번호묶음중_부적절한_인덱스로_번호묶음을_반환시_빈값을_응답_할_수_있다() {
        List<Set<Integer>> manualList = List.of(
                Set.of(1,2,3,4,5,6),
                Set.of(2,3,4,5,6,7)
        );

        ManualLottos manualLottos = new ManualLottos(manualList);

        assertThat(
                manualLottos.findManualLottoByIdx(2)
        ).isEmpty();
    }

    @Test
    void 수동로또번호묶음을_로또묶음_일급컬렉션으로_변환_할_수_있다() {
        List<Set<Integer>> manualList = List.of(
                Set.of(1,2,3,4,5,6),
                Set.of(2,3,4,5,6,7)
        );

        Lottos manualLottos = new ManualLottos(manualList).convertToLottos();

        assertThat(
                manualLottos.size()
        ).isEqualTo(2);
    }
}