package lotto;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {

    @Test
    public void 일치개수5개_보너스일치_2등() {
        // given
        int countOfMatch = 5;
        // when
        Prize prize = Prize.valueOf(countOfMatch, true);
        // then
        assertThat(prize).isEqualByComparingTo(Prize.SECOND_PRIZE);
    }

    @Test
    public void 일치개수5개__3등() {
        // given
        int countOfMatch = 5;
        // when
        Prize prize = Prize.valueOf(countOfMatch, false);
        // then
        assertThat(prize).isEqualByComparingTo(Prize.THIRD_PRIZE);
    }

    @Test
    public void 일등1개_사등1개_상금계산() {
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
        assertThat(sum).isEqualTo(4000050000L);
    }
}