package step2;

import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.MatchResult;
import step2.domain.Winning;

import static org.assertj.core.api.Assertions.*;
import static step2.util.LottoNumberUtils.of;

public class MatchResultTest {

    @Test
    void sameCount() {
        Lotto lotto = new Lotto(of(2, 4, 5, 6, 3, 9));
        Winning winningNums = new Winning(of(1, 2, 3, 4, 5, 6));
        MatchResult matchResult = winningNums.match(lotto);
        assertThat(matchResult.getMatchedCount()).isEqualTo(5);
    }
}
