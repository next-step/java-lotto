package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinTest {
    @Test
    @DisplayName("비교 결과를 구하는 테스트")
    void getMatchResult() {
        DrawnLotto drawnLotto = new DrawnLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 45);
        LottoEntry lottoEntry1 = new LottoEntry(Arrays.asList(1, 2, 3, 7, 8, 9));

        LottoWin result = LottoWin.getMatchResult(drawnLotto, lottoEntry1);

        assertThat(result).isEqualTo(LottoWin.THREE_MATCH);

        LottoEntry lottoEntry2 = new LottoEntry(Arrays.asList(1, 2, 3, 4, 5, 45));

        LottoWin result2 = LottoWin.getMatchResult(drawnLotto, lottoEntry2);

        assertThat(result2).isEqualTo(LottoWin.FIVE_WITH_BONUS_MATCH);
    }

    @Test
    @DisplayName("숫자로 부터 LottoWin enum을 구하는 테스트")
    void fromMatchTest() {
        assertThat(LottoWin.fromMatch(3, false).orElse(LottoWin.NONE_MATCH)).isEqualTo(LottoWin.THREE_MATCH);
        assertThat(LottoWin.fromMatch(5, true).orElse(LottoWin.NONE_MATCH)).isEqualTo(LottoWin.FIVE_WITH_BONUS_MATCH);
        assertThat(LottoWin.fromMatch(6, false).orElse(LottoWin.NONE_MATCH)).isEqualTo(LottoWin.SIX_MATCH);
    }
}
