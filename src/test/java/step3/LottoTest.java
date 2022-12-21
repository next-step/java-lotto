package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Lotto;
import step3.domain.WinningLotto;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("로또 당첨 번호 비교해서 몇개 일치하는지 테스트")
    public void matchCountTest() {
        Lotto lotto1 = new Lotto(1, 2, 3, 4, 5, 6);

        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 16", 7);

        int matchCount = lotto1.matchCount(winningLotto);

        assertThat(matchCount).isEqualTo(6);
    }

}
