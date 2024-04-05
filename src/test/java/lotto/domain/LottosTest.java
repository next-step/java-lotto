package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    @DisplayName("수동 로또와 자동 로또를 합쳐서 모든 로또를 반환한다.")
    void AllLottos_ManualAndAuto() {
        final List<Lotto> manualLottos = List.of(
                lotto(1, 2, 3, 4, 5, 6),
                lotto(1, 2, 3, 4, 5, 7),
                lotto(1, 2, 3, 4, 5, 8)
        );
        final List<Lotto> autoLottos = List.of(
                lotto(10, 11, 12, 13, 14, 15),
                lotto(10, 11, 12, 13, 14, 16)
        );
        final Lottos lottos = new Lottos(manualLottos, autoLottos);

        assertThat(lottos.allLottos())
                .hasSize(manualLottos.size() + autoLottos.size())
                .containsAll(manualLottos)
                .containsAll(autoLottos);
    }

    private Lotto lotto(final int... numbers) {
        final List<Integer> lottoNumbers = Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toUnmodifiableList());

        return Lotto.from(lottoNumbers);
    }
}
