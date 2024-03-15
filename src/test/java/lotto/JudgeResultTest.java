package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JudgeResultTest {

    @Test
    @DisplayName("수익률을 계산한다")
    void calcReturnRate() {
        JudgeResult judgeResult1 = new JudgeResult(1, 1, 1, 1);
        double returnRate1 = judgeResult1.calcReturnRate(new Money(20016000));
        assertThat(returnRate1).isCloseTo(99.99, Percentage.withPercentage(0.01));

        JudgeResult judgeResult2 = new JudgeResult(1, 0, 0, 0);
        double returnRate2 = judgeResult2.calcReturnRate(new Money(50000));
        assertThat(returnRate2).isCloseTo(0.1, Percentage.withPercentage(0.01));
    }
}
