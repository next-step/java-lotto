package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ManualLottoMachineTest {

    @Test
    @DisplayName("수동으로 로또를 생성한다.")
    void create_manual_lottos() {
        // given
        ManualLottoMachine manualLottoMachine = new ManualLottoMachine();

        // when
        Lottos result = manualLottoMachine.createLottos(createLottos());

        // then
        assertThat(result).isEqualTo(new Lottos(createExpectedLotto(), createExpectedLotto(), createExpectedLotto()));
    }

    private List<List<Integer>> createLottos() {
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            lottos.add(new ArrayList<>());
        }
        for (List<Integer> lotto : lottos) {
            lotto.addAll(List.of(1, 2, 3, 4, 5, 6));
        }
        return lottos;
    }

    private Lotto createExpectedLotto() {
        return new Lotto(1, 2, 3, 4, 5, 6);
    }
}
