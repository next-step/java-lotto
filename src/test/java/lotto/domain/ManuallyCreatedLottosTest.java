package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class ManuallyCreatedLottosTest {

    @Test
    @DisplayName("[요구사항 1] 수동으로 입력한 로또 번호를 올바르게 Lotto List로 반환")
    void 요구사항_1() {
        // given : 수동 로또 3개 입력
        TreeSet<Integer> manuallyCreatedLotto = new TreeSet<>(Set.of(1, 2, 3, 4, 5, 6));
        TreeSet<Integer> manuallyCreatedLotto2 = new TreeSet<>(Set.of(1, 2, 3, 4, 5, 7));
        TreeSet<Integer> manuallyCreatedLotto3 = new TreeSet<>(Set.of(1, 2, 3, 4, 5, 8));

        List<Lotto> expectedLottos = Stream.of(
                        Set.of(1, 2, 3, 4, 5, 6),
                        Set.of(1, 2, 3, 4, 5, 7),
                        Set.of(1, 2, 3, 4, 5, 8)
                )
                .map(numbers -> new Lotto(numbers.stream()
                        .map(LottoNumber::new)
                        .collect(Collectors.toCollection(TreeSet::new))))
                .collect(Collectors.toList());

        // when
        ManuallyCreatedLottos manuallyCreatedLottos = new ManuallyCreatedLottos(List.of(manuallyCreatedLotto, manuallyCreatedLotto2, manuallyCreatedLotto3));

        // then
        assertThat(manuallyCreatedLottos.getManuallyCreatedLottos()).isEqualTo(expectedLottos);
    }
}
