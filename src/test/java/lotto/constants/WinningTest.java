package lotto.constants;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningTest {

    @Test
    @DisplayName("당첨된 번호의 갯수의 따라 로또 등급이 나온다.")
    void match() {
        assertThat(Winning.of(6, false) == Winning.FIRST).isTrue();
        assertThat(Winning.of(5, true) == Winning.SECOND).isTrue();
        assertThat(Winning.of(5, false) == Winning.THIRD).isTrue();
        assertThat(Winning.of(4, false) == Winning.FOURTH).isTrue();
        assertThat(Winning.of(3, false) == Winning.FIFTH).isTrue();
        assertThat(Winning.of(2, false) == Winning.FAIL).isTrue();
        assertThat(Winning.of(0, false) == Winning.FAIL).isTrue();
    }
}
