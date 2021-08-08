package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.enums.Match;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchTest {
    @Test
    @DisplayName("비교 결과를 구하는 테스트")
    void getMatchResult() {
        DrawnLotto drawnLotto = new DrawnLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 45);
        LottoEntry lottoEntry1 = new LottoEntry(Arrays.asList(1, 2, 3, 7, 8, 9));

        Match result = Match.getMatchResult(drawnLotto, lottoEntry1);

        assertThat(result).isEqualTo(Match.THREE_MATCH);

        LottoEntry lottoEntry2 = new LottoEntry(Arrays.asList(1, 2, 3, 4, 5, 45));

        Match result2 = Match.getMatchResult(drawnLotto, lottoEntry2);

        assertThat(result2).isEqualTo(Match.FIVE_WITH_BONUS_MATCH);
    }

    @Test
    @DisplayName("숫자로 부터 LottoWin enum을 구하는 테스트")
    void fromMatchTest() {
        assertThat(Match.fromMatch(3, false).orElse(Match.NONE_MATCH)).isEqualTo(Match.THREE_MATCH);
        assertThat(Match.fromMatch(5, true).orElse(Match.NONE_MATCH)).isEqualTo(Match.FIVE_WITH_BONUS_MATCH);
        assertThat(Match.fromMatch(6, false).orElse(Match.NONE_MATCH)).isEqualTo(Match.SIX_MATCH);
    }
}
