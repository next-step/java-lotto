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
            Prize.FIRST_PLACE, 1, Prize.THIRD_PLACE, 1,
            Prize.FOURTH_PLACE, 1, Prize.FIFTH_PLACE, 1
        ));
        double returnRate1 = prizes1.calcReturnRate(20016000);
        assertThat(returnRate1).isCloseTo(99.99, Percentage.withPercentage(0.01));

        Prizes prizes2 = new Prizes(Map.of(Prize.FIFTH_PLACE, 1));
        double returnRate2 = prizes2.calcReturnRate(50000);
        assertThat(returnRate2).isCloseTo(0.1, Percentage.withPercentage(0.01));
    }
}
