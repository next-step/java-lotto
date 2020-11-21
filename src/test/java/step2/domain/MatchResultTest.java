package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.Rank;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchResultTest {
    @DisplayName("3개 맞췄을 때 수익률을 계산한다.")
    @Test
    void rateOfReturn() {
        MatchResult matchResult = new MatchResult();
        matchResult.add(Rank.FIFTH);
        for (int i = 0; i < 13; i++) {
            matchResult.add(Rank.MISS);
        }

        assertThat(matchResult.getRateOfReturn()) //
                .isEqualTo(0.35714287f);
    }

    @DisplayName("투자 없이 이익률만 계산하는 경우")
    @Test
    void zeroInput() {
        assertThat(new MatchResult().getRateOfReturn()) //
                .isEqualTo(0);
    }

}
