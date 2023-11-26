package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    @DisplayName("입력 개수만큼 자동 로또가 발급된다.")
    void lotts_auto() {
        List<Lotto> lottos = LottoMachine.issueAutoLottos(5);
        assertThat(lottos).hasSize(5);
    }

    @Test
    @DisplayName("입력 개수만큼 수동 로또가 발급된다.")
    void lottos_manual() {
        List<Lotto> lottos = LottoMachine.issueManualLottos(List.of("8, 21, 23, 41, 42, 43", "3, 5, 11, 16, 32, 38", "7, 11, 16, 35, 36, 44"));
        assertThat(lottos).hasSize(3);
    }

    @Test
    @DisplayName("로또1과 로또2를 합칠 수 있다.")
    void lottos_addAll() {
        List<Lotto> lotto1 = LottoMachine.issueManualLottos(List.of("1, 2, 3, 4, 5, 6", "8, 21, 23, 41, 42, 43"));
        List<Lotto> lotto2 = LottoMachine.issueManualLottos(List.of("7, 11, 16, 35, 36, 44"));

        List<Lotto> lottos = LottoMachine.addAllLottos(lotto1, lotto2);

        assertThat(lottos).hasSize(3)
                .containsAnyElementsOf(lotto1)
                .containsAnyElementsOf(lotto2);
    }
}
