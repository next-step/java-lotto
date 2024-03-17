package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import lotto.domain.Prize;
import lotto.domain.Prizes;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizesTest {

    @Test
    @DisplayName("수익률을 계산한다")
    void calcReturnRate() {
        Prizes prizes1 = new Prizes(Map.of(
            Prize.MATCHING_SIX, 1, Prize.MATCHING_FIVE, 1,
            Prize.MATCHING_FOUR, 1, Prize.MATCHING_THREE, 1
        ));
        double returnRate1 = prizes1.calcReturnRate(20016000);
        assertThat(returnRate1).isCloseTo(99.99, Percentage.withPercentage(0.01));

        Prizes prizes2 = new Prizes(Map.of(Prize.MATCHING_THREE, 1));
        double returnRate2 = prizes2.calcReturnRate(50000);
        assertThat(returnRate2).isCloseTo(0.1, Percentage.withPercentage(0.01));
    }
}
