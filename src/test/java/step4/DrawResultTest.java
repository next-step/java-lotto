package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.enums.DrawResult;

import static org.assertj.core.api.Assertions.assertThat;

public class DrawResultTest {
    @Test
    @DisplayName("숫자로 부터 LottoWin enum을 구하는 테스트")
    void fromMatchTest() {
        assertThat(DrawResult.fromMatch(3, false).orElse(DrawResult.NONE_MATCH)).isEqualTo(DrawResult.THREE_MATCH);
        assertThat(DrawResult.fromMatch(5, true).orElse(DrawResult.NONE_MATCH)).isEqualTo(DrawResult.FIVE_WITH_BONUS_MATCH);
        assertThat(DrawResult.fromMatch(6, false).orElse(DrawResult.NONE_MATCH)).isEqualTo(DrawResult.SIX_MATCH);
    }
}
