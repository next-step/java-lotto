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

    @Test
    void 수익률_확인_테스트(){
        Lottos lottos = new Lottos(List.of(
            Lotto.print(() -> Number.of(8, 21, 23, 41, 42, 43)),
            Lotto.print(() -> Number.of(3, 5, 11, 16, 32, 38)),
            Lotto.print(() -> Number.of(7, 11, 16, 35, 36, 44)),
            Lotto.print(() -> Number.of(1, 8, 11, 31, 41, 42)),
            Lotto.print(() -> Number.of(13, 14, 16, 38, 42, 45)),
            Lotto.print(() -> Number.of(7, 11, 30, 40, 42, 43)),
            Lotto.print(() -> Number.of(2, 13, 22, 32, 38, 45)),
            Lotto.print(() -> Number.of(23, 25, 33, 36, 39, 41)),
            Lotto.print(() -> Number.of(1, 3, 5, 14, 22, 45)),
            Lotto.print(() -> Number.of(5, 9, 38, 41, 43, 44)),
            Lotto.print(() -> Number.of(2, 8, 9, 18, 19, 21)),
            Lotto.print(() -> Number.of(13, 14, 18, 21, 23, 35)),
            Lotto.print(() -> Number.of(17, 21, 29, 37, 42, 45)),
            Lotto.print(() -> Number.of(3, 8, 27, 30, 35, 44))
        ));

        List<Number> winners = Number.of(1, 2, 3, 4, 5, 6);

        Assertions.assertThat(lottos.calculateProfitRate(winners)).isEqualTo(0.35);
    }
}
