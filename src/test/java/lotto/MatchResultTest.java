package lotto;

import lotto.domain.MatchResult;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchResultTest {
    @Test
    public void constructor() {
        MatchResult matchResult = new MatchResult(3, false);
        assertThat(matchResult.getCount()).isEqualTo(3);
        assertThat(matchResult.getIsBonus()).isEqualTo(false);
    }
}
