package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottosTest {

    @Test
    void 등수별_인원_조회() {
        Lottos lottos = new Lottos(List.of(
            Lotto.print(() -> Number.of(1, 2, 3, 4, 5, 6)),
            Lotto.print(() -> Number.of(2, 3, 4, 5, 6, 7)),
            Lotto.print(() -> Number.of(3, 4, 5, 6, 7, 8)),
            Lotto.print(() -> Number.of(4, 5, 6, 7, 8, 9))
        ));

        List<Number> winners = Number.of(1, 2, 3, 4, 5, 6);

        Assertions.assertThat(lottos.numberOfFirstDivision(winners)).isEqualTo(1L);
        Assertions.assertThat(lottos.numberOfSecondDivision(winners)).isEqualTo(1L);
        Assertions.assertThat(lottos.numberOfThirdDivision(winners)).isEqualTo(1L);
        Assertions.assertThat(lottos.numberOfFourthDivision(winners)).isEqualTo(1L);
    }
}
