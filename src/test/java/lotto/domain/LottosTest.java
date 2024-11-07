package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    void create() {
        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(1, 2, 3, 4, 5, 7),
                new Lotto(1, 2, 3, 4, 5, 8)
        ));

        assertThat(lottos).isEqualTo(new Lottos(Arrays.asList(
                new Lotto("1, 2, 3, 4, 5, 6"),
                new Lotto("1, 2, 3, 4, 5, 7"),
                new Lotto("1, 2, 3, 4, 5, 8")
        )));
    }

    @Test
    void 당첨결과() {
        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(1, 2, 3, 4, 5, 7),
                new Lotto(1, 2, 3, 4, 5, 8),
                new Lotto(1, 2, 3, 4, 8, 9),
                new Lotto(1, 2, 3, 7, 8, 9),
                new Lotto(1, 2, 7, 8, 9, 10)
        ));
        WinningLotto lastWinningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        Map<LottoRank, Integer> resultMap = new HashMap<>();
        resultMap.put(LottoRank.FIRST, 1);
        resultMap.put(LottoRank.SECOND, 1);
        resultMap.put(LottoRank.THIRD, 1);
        resultMap.put(LottoRank.FOURTH, 1);
        resultMap.put(LottoRank.FIFTH, 1);
        LottoResult lottoResult = new LottoResult(resultMap);

        assertThat(lottos.getLottoResult(lastWinningLotto)).isEqualTo(lottoResult);
    }
}