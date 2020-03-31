package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    private String bonusBall = "7";
    private String winningLottoValue = "1,2,3,4,5,6";

    @Test
    void getMatchCount() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningLottoValue), bonusBall);

        int matchCount = winningLotto.getMatchCount(new Lotto("1,2,3,7,8,9"));

        assertThat(matchCount).isEqualTo(3);
    }

    @Test
    void matchBonus() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningLottoValue), bonusBall);

        assertThat(winningLotto.matchBonus(new Lotto("1,2,3,4,5,6"))).isFalse();
        assertThat(winningLotto.matchBonus(new Lotto("1,2,3,4,5,7"))).isTrue();
    }
}