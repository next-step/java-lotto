package lotto;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {

    @Test
    public void 일치개수5개_2등() {
        // given
        int countOfMatch = 5;
        // when
        Prize prize = Prize.fromNumberOfMatch(countOfMatch);
        // then
        assertThat(prize).isEqualByComparingTo(Prize.SECOND_PRIZE);
    }

    @Test
    public void 일등2개_상금계산() {
        // given
        long sum = 0L;
        Map<Prize, Integer> prizeCount = new HashMap<>();
        prizeCount.put(Prize.FIRST_PRIZE, 2);
        prizeCount.put(Prize.FOURTH_PRIZE, 1);
        // when
        for (Prize prize : Prize.values()) {
            sum += prize.calculatePrizeMoneyBy(prizeCount.getOrDefault(prize, 0));
        }
        // then
        assertThat(sum).isEqualTo(4000005000L);
    }
}