package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningLottoTest {

    WinningLotto winningLotto;

    @BeforeEach
    void setup() {
        winningLotto = new WinningLotto(Lotto.ofComma("1,2,3,4,5,6"), 7);
    }

    @DisplayName("당첨번호와 보너스번호 중복 불가")
    @Test
    void createError() {
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningLotto(Lotto.ofComma("1,2,3,4,5,6"), 1));
    }

    @DisplayName("2등")
    @Test
    void matchSecond() {
        Lotto buyLotto = Lotto.ofComma("1,2,3,4,5,7");
        assertThat(winningLotto.match(buyLotto)).isEqualTo(Rank.SECOND);
    }

    @DisplayName("3등")
    @Test
    void matchFirst() {
        Lotto buyLotto = Lotto.ofComma("1,2,3,4,5,8");
        assertThat(winningLotto.match(buyLotto)).isEqualTo(Rank.THIRD);
    }

}
