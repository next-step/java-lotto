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
    void create2() {
        //given
        Map<MatchCount, Integer> result = new HashMap<MatchCount, Integer>() {{
            put(MatchCount.FORTH, 1);
            put(MatchCount.FIRST, 2);
            put(MatchCount.SECOND_WITH_BONUS, 3);
        }};

        //when
        MatchResult matchResult = new MatchResult(result);

        //then
        Map<MatchCount, Integer> matchMap = new HashMap<MatchCount, Integer>() {{
            put(MatchCount.FORTH, 1);
            put(MatchCount.THIRD, 0);
            put(MatchCount.SECOND, 0);
            put(MatchCount.SECOND_WITH_BONUS, 3);
            put(MatchCount.FIRST, 2);
        }};

        assertThat(matchResult).isEqualTo(new MatchResult(matchMap));
    }

    @DisplayName("수익률 계산")
    @Test
    void calculateProfit() {
        //given
        Map<MatchCount, Integer> result = new HashMap<MatchCount, Integer>() {{
            put(MatchCount.FORTH, 1);
            put(MatchCount.MISS, 13);
        }};
        MatchResult matchResult = new MatchResult(result);

        //when
        BigDecimal profit = matchResult.calculateProfit();
        assertThat(profit).isEqualTo(new BigDecimal(5_000.0 / 14_000));
    }
}
