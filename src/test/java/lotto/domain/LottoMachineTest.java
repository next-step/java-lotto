package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    @DisplayName("입력 개수만큼 자동 로또가 발급된다.")
    void lotts_auto() {
        Lottos lottos = LottoMachine.issueAutoLottos(5);
        assertThat(lottos.getLottos()).hasSize(5);
    }

    @Test
    @DisplayName("입력 개수만큼 수동 로또가 발급된다.")
    void lottos_manual() {
        Lottos lottos = LottoMachine.issueManualLottos(List.of("8, 21, 23, 41, 42, 43", "3, 5, 11, 16, 32, 38", "7, 11, 16, 35, 36, 44"));
        assertThat(lottos.getLottos()).hasSize(3);
    }
}
