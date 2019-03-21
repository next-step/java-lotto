package domain;

import org.junit.Test;
import util.WinType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    public void 당첨결과_조회하기() {
        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto(15, 22, 18, 43, 41, 2),
                new Lotto(5, 33, 1, 43, 41, 32),
                new Lotto(2, 32, 18, 4, 42, 6),
                new Lotto(34, 42, 18, 43, 1, 2)
        ));

        LottoResult result = lottos.lottery(4000, new Lotto(5, 33, 1, 43, 41, 32));

        assertThat(result.countWin(WinType.SIX)).isEqualTo(1);
    }
    @Test
    public void 당첨금액_조회하기() {
        int money = 50000;
        Map<WinType, Long> result = new HashMap<>();
        result.put(WinType.THREE, 1L);
        result.put(WinType.FOUR, 2L);

        LottoResult lottoResult = new LottoResult(money, result);

        assertThat(lottoResult.getYield()).isEqualTo(2.0f);
    }
}