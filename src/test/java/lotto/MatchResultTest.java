package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchResultTest {

    @Test
    @DisplayName("수익률 계산 : 수익률 = {(당첨금액*개수)의 합 / 구입금액} * 100 ")
    void 수익률_계산() {
        MatchResult matchResult = new MatchResult(Arrays.asList(1,0,0,0));

        double returnRate = matchResult.calculateReturnRate(14000);

        assertThat(returnRate).isEqualTo(0.35);
    }
}
