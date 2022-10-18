package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

public class LottosTest {

    @Test
    void 로또_결과_통계_조회() {
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
        LottoResult result = lottos.getResult(Number.of(1, 2, 3, 4, 5, 6));

        Assertions.assertThat(result).isEqualTo(new LottoResult(List.of(
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
        ), Number.of(1, 2, 3, 4, 5, 6)));
    }
}
