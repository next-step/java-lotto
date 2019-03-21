package domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    public void 로또구매_정상() {
        Lottos lottos = new Lottos(Arrays.asList(new Lotto(1, 2, 3, 4, 5, 6)));

        assertThat(lottos.size()).isEqualTo(1);
    }

    @Test
    public void 로또_당첨_확인() {
        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto(15, 22, 18, 43, 41, 2),
                new Lotto(5, 33, 1, 43, 41, 32),
                new Lotto(2, 32, 18, 4, 42, 6),
                new Lotto(34, 42, 18, 43, 1, 2)
        ));

        LottoResult result = lottos.lottery(4000, new Lotto(5, 33, 1, 43, 41, 32));

        assertThat(result.getYield()).isEqualTo(500000.0f);
    }
}