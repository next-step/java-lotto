package step4.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

public class RevenueTest {

    @Test
    void calculate_수익률_로또만원사고_5000원당첨() {
        Map<Prize, Long> enumMap = new EnumMap<>(Prize.class);
        enumMap.put(Prize.THREE_PRIZE, 1L);
        LottoResult results = new LottoResult(enumMap);
        Assertions.assertThat(new Revenue(results).calculatePercentage(10000)).isEqualTo(0.5);
    }
}
