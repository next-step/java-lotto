package domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    public void 로또_당첨_확인() {
        Lottos lottos = new Lottos(Arrays.asList(
                Lotto.of(Numbers.of(15, 22, 18, 43, 41, 2)),
                Lotto.of(Numbers.of(5, 33, 1, 43, 41, 32)),
                Lotto.of(Numbers.of(2, 32, 18, 4, 42, 6)),
                Lotto.of(Numbers.of(34, 42, 18, 43, 1, 2))
        ));

        LottoResult result = lottos.figure(4000, new WinningLotto(Numbers.of(5, 33, 1, 43, 41, 32), 12));

        assertThat(result.getYield()).isEqualTo(500000.0f);
    }
}