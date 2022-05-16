package lotto.domain.result;

import lotto.domain.LottoReward;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class MatchResultTest {
    @Test
    void 상금_테스트() {
        assertThat(new MatchResult(1, LottoReward.FIFTH).getMatchReward()).isEqualTo(5_000);
    }

    @Test
    void 당첨_증가_테스트() {
        MatchResult matchResult = new MatchResult(0, LottoReward.FIFTH);
        matchResult.addMatchCount();

        assertThat(matchResult.getMatchReward()).isEqualTo(5000);
    }
}
