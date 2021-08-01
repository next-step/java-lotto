package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinTest {
    @Test
    @DisplayName("비교 결과를 구하는 테스트")
    void getMatchResult() {
        LottoEntry lottoEntry1 = new LottoEntry(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoEntry lottoEntry2 = new LottoEntry(Arrays.asList(1, 2, 3, 7, 8, 9));

        LottoWin result = LottoWin.getMatchResult(lottoEntry1, lottoEntry2);

        assertThat(result).isEqualTo(LottoWin.THREE_MATCH);
    }

    @Test
    @DisplayName("숫자로 부터 LottoWin enum을 구하는 테스트")
    void fromMatchTest() {
        assertThat(LottoWin.fromMatch(3).orElse(LottoWin.NONE_WIN)).isEqualTo(LottoWin.THREE_MATCH);

        assertThat(LottoWin.fromMatch(6).orElse(LottoWin.NONE_WIN)).isEqualTo(LottoWin.SIX_MATCH);
    }
}
