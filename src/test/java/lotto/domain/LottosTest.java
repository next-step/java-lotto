package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    @DisplayName("로또1과 로또2를 합칠 수 있다.")
    void lottos_addAll() {
        Lottos lotto1 = LottoMachine.issueManualLottos(List.of("1, 2, 3, 4, 5, 6", "8, 21, 23, 41, 42, 43"));
        Lottos lotto2 = LottoMachine.issueManualLottos(List.of("7, 11, 16, 35, 36, 44"));

        Lottos lottos = new Lottos(lotto1, lotto2);

        assertThat(lottos.getLottos()).hasSize(3)
                .containsAnyElementsOf(lotto1.getLottos())
                .containsAnyElementsOf(lotto2.getLottos());
    }
}
