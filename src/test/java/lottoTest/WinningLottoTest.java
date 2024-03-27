package lottoTest;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.Lotto;
import lotto.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    @DisplayName("당첨번호와 일치하는 숫자의 갯수 return")
    void COMPARE_WINNING_LOTTO_THEN_RETURN_MATCH_COUNT() {
        Lotto lotto = new Lotto(new String[] {"1","2","3","4","5","6"});

        WinningLotto winningLotto = new WinningLotto(
            new String[] {"1","2","3","4","5","6"}, "7");

        assertThat(winningLotto.countMatch(lotto)).isEqualTo(6);
    }

    @Test
    @DisplayName("보너스 번호 맞췄을시 true return")
    void COMPARE_BONUS_NUMBER_THEN_RETURN_TRUE() {
        Lotto lotto = new Lotto(new String[] {"1","2","3","4","5","6"});

        WinningLotto winningLotto = new WinningLotto(
            new String[] {"1","2","3","4","5","8"}, "6");

        assertThat(winningLotto.matchBonus(lotto)).isEqualTo(true);
    }
}
