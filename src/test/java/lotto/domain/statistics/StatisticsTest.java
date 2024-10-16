package lotto.domain.statistics;

import lotto.domain.Prize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.statistics.Statistics.*;
import static org.assertj.core.api.Assertions.*;

class StatisticsTest {

    private Map<Prize, Integer> map = new HashMap<>();

    @BeforeEach
    void setUp() {
        map.put(Prize.FIRST, 0);
        map.put(Prize.SECOND, 0);
        map.put(Prize.THIRD, 0);
        map.put(Prize.FOURTH, 0);
        map.put(Prize.FIFTH, 1);
        map.put(Prize.MISS, 0);
    }

    @Test
    @DisplayName("prizeMatch 메서드가 각 당첨 금액의 개수를 정확히 반환 테스트")
    void prize_match_메서드_테스트() {
        List<Integer> prizeCountList = getPrizeCounts(map);

        assertThat(prizeCountList).isEqualTo(List.of(0, 1, 0, 0, 0, 0));
    }

    @Test
    @DisplayName("prizeAllMountPrice 메서드가 총 당첨 금액을 정확히 반환 테스트")
    void prize_all_mountPrice_메서드_테스트() {
        int lottoPurchaseCount = 14;
        double rateOfReturn = calculateReturnRatio(lottoPurchaseCount, map);

        assertThat(rateOfReturn).isEqualTo(0.35);
    }


}