package lotto.domain;

import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.dto.ManualLottoOrderSheet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    @DisplayName("로또기계 생성 테스트")
    void createLottoMachineTest() {
        new LottoMachine();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 9})
    @DisplayName("로또기계로 돈만큼 자동 로또 구매 테스트")
    void purchaseManualLottosTest(int input) {
        Lottos lottos = new LottoMachine().purchaseAutomaticLottos(input);
        assertThat(
                lottos.getLottoCount()
        ).isEqualTo(input);
    }

    @Test
    @DisplayName("로또기계로 돈만큼 수동 로또 구매 테스트")
    void purchaseAutomaticLottosTest() {
        List<List<Integer>> inputs = new ArrayList<>();
        inputs.add(Arrays.asList(1, 2, 3, 4, 5, 6));
        inputs.add(Arrays.asList(1, 2, 3, 4, 5, 6));
        inputs.add(Arrays.asList(1, 2, 3, 4, 5, 6));

        Lottos lottos = new LottoMachine().purchaseManualLottos(new ManualLottoOrderSheet(inputs));

        assertThat(
                lottos.getLottoCount()
        ).isEqualTo(3);
    }
}
