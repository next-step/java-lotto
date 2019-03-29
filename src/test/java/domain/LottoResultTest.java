package domain;

import org.junit.Test;
import util.WinType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
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