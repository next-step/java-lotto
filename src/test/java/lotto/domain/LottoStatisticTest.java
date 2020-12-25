package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LottoStatisticTest {

    @DisplayName("통계 카운트")
    @Test
    void setRankCount() {
        LottoStatistic statistic = new LottoStatistic(Arrays.asList(3,3,3,4,5,6), new LottoCount("15000"));
        System.out.println(statistic.message());
    }
}
