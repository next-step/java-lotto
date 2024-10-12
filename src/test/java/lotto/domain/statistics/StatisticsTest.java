package lotto.domain.statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StatisticsTest {

    private Map<Integer, Integer> map = new HashMap<>();

    @BeforeEach
    void setUp() {
        map.put(3, 1);
        map.put(4, 0);
        map.put(5, 0);
        map.put(6, 0);
    }

    @Test
    @DisplayName("prizeMatch 메서드가 각 당첨 금액의 개수를 정확히 반환 테스트")
    void prize_match_메서드_테스트() {
        Statistics statistics = new Statistics(map);
        List<Integer> prizeCountList = statistics.prizeMatch();

        assertThat(prizeCountList).isEqualTo(List.of(1, 0, 0, 0));
    }

    @Test
    @DisplayName("prizeAllMountPrice 메서드가 총 당첨 금액을 정확히 반환 테스트")
    void prize_all_mountPrice_메서드_테스트() {
        Statistics statistics = new Statistics(map);
        int lottoPurchaseCount = 14;
        double rateOfReturn = statistics.allMountPrice(lottoPurchaseCount);

        assertThat(rateOfReturn).isEqualTo(0.35);
    }


}