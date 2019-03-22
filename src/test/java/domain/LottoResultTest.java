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
                Lotto.of(Numbers.of(15, 22, 18, 43, 41, 2), 4),
                Lotto.of(Numbers.of(5, 33, 1, 43, 41, 32), 22),
                Lotto.of(Numbers.of(2, 32, 18, 4, 42, 6), 11),
                Lotto.of(Numbers.of(34, 42, 18, 43, 1, 2), 24)
        ));

        LottoResult result = lottos.figure(4000, Numbers.of(5, 33, 1, 43, 41, 32));

        assertThat(result.countWin(WinType.FIRST)).isEqualTo(1);
    }

    @Test
    public void 당첨금액_조회하기() {
        int money = 50_000;

        Map<WinType, Long> result = new HashMap<>();
        result.put(WinType.FOURTH, 1L);
        result.put(WinType.THIRD, 2L);

        LottoResult lottoResult = new LottoResult(money, result);

        assertThat(lottoResult.getYield()).isEqualTo(7.0f);
    }
}