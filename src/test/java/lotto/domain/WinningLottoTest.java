package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    private String bonusBall = "7";
    private String winningLottoValue = "1,2,3,4,5,6";

    @Test
    @DisplayName("당첨 번호와 매칭 되는 로또 번호 수 테스트")
    void getMatchCount() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningLottoValue), bonusBall);

        int matchCount = winningLotto.getMatchCount(new Lotto("1,2,3,7,8,9"));

        assertThat(matchCount).isEqualTo(3);
    }

    @Test
    @DisplayName("보너스 번호와 일치하는지에 대한 테스트")
    void matchBonus() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningLottoValue), bonusBall);

        assertThat(winningLotto.matchBonus(new Lotto("1,2,3,4,5,6"))).isFalse();
        assertThat(winningLotto.matchBonus(new Lotto("1,2,3,4,5,7"))).isTrue();
    }
}