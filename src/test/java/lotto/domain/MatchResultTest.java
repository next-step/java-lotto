package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MatchResultTest {

    @DisplayName("당첨통계 객체 생성")
    @Test
    void create() {
        //given
        Map<Integer, Integer> result = new HashMap<>();
        result.put(3,1);
        result.put(6,2);
        result.put(2,3);

        //when
        MatchResult matchResult = new MatchResult(result);

        //then
        Map<Integer, Integer> matchMap = new HashMap<>();
        matchMap.put(3, 1);
        matchMap.put(4, 0);
        matchMap.put(5, 0);
        matchMap.put(6, 2);

        assertThat(matchResult).isEqualTo(new MatchResult(matchMap));
    }

    @DisplayName("수익률 계산")
    @Test
    void calculateProfit() {
        //given
        Map<Integer, Integer> result = new HashMap<>();
        result.put(3, 1);
        result.put(0, 13);
        MatchResult matchResult = new MatchResult(result);

        //when
        BigDecimal profit = matchResult.calculateProfit();
        assertThat(profit).isEqualTo(BigDecimal.valueOf(5_000.0 / 14_000));
    }
}
