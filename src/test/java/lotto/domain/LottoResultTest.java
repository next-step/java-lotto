package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    @DisplayName("로또 결과 값으로 수익률을 계산한다")
    void calculateProfitRateTest() {
        Map<Prize, Integer> map = new HashMap<>();
        map.put(Prize.FIRST, 0);
        map.put(Prize.SECOND, 0);
        map.put(Prize.THIRD, 0);
        map.put(Prize.FOURTH, 1);

        LottoResult lottoResult = new LottoResult(map);
        double profitRate = lottoResult.calculateProfitRate(14000);
        assertThat(profitRate).isEqualTo(0.35);
    }
}