package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    private Lotto winningLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));

    @Test
    @DisplayName("1등 당첨 test")
    void firstWinningTest() {
        assertThat(winningLotto.calculateRank(new Lotto(Arrays.asList(6,5,4,3,2,1))))
                .isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("3등 당첨 test")
    void thirdWinningTest() {
        assertThat(winningLotto.calculateRank(new Lotto(Arrays.asList(11,5,9,3,8,1))))
                .isEqualTo(Rank.FORTH);
    }
    @Test
    @DisplayName("미당첨 test")
    void notWinningTest() {
        assertThat(winningLotto.calculateRank(new Lotto(Arrays.asList(11,43,9,26,8,15))))
                .isEqualTo(Rank.MISS);
    }

    @Test
    @DisplayName("입력값 split test")
    void splitLottoStringTest() {
        Lotto splitLotto = new Lotto("1, 2, 3, 4, 5, 6");
        assertThat(winningLotto.equals(splitLotto)).isEqualTo(true);
    }

    @Test
    @DisplayName("입력값 유효성검사(문자) test")
    void validationStringTest() {
        assertThatThrownBy(() -> new Lotto("1, 2, 3, e, 5, 6"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("입력값 유효성검사(음수) test")
    void validationMinusNumTest() {
        assertThatThrownBy(() -> new Lotto("1, 2, 3, -4, 5, 6"))
                .isInstanceOf(RuntimeException.class);
    }

}
