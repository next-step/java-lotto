package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningLottoTest {
    private WinningLotto winningLotto;
    private String numbers = "1,2,3,4,5,6";
    private int bonusNumber = 7;

    @BeforeEach
    public void setup() {
        winningLotto = new WinningLotto(numbers, bonusNumber);
    }

    @Test
    public void equal() {
        assertThat(winningLotto).isEqualTo(new WinningLotto(numbers, bonusNumber));
    }

    @Test
    public void 로또번호_보너스번호_중복X() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
           new WinningLotto("1,2,3,4,5,6", 6);
        });
    }

    @Test
    public void match_6개_1등_테스트() {
        assertThat(winningLotto.match(Lotto.of(1, 2, 3, 4, 5, 6))).isEqualTo(Rank.FIRST);
    }

    @Test
    public void match_5개_보너스_매치_2등_테스트() {
        assertThat(winningLotto.match(Lotto.of(1, 2, 3, 4, 5, 7))).isEqualTo(Rank.SECOND);
    }

    @Test
    public void match_5개_3등_테스트() {
        assertThat(winningLotto.match(Lotto.of(1, 2, 3, 4, 5, 8))).isEqualTo(Rank.THIRD);
    }

    @Test
    public void match_4개_4등_테스트() {
        assertThat(winningLotto.match(Lotto.of(1, 2, 3, 4, 8, 9))).isEqualTo(Rank.FOURTH);
    }

    @Test
    public void match_3개_5등_테스트() {
        assertThat(winningLotto.match(Lotto.of(1, 2, 3, 8, 9, 10))).isEqualTo(Rank.FIFTH);
    }

    @Test
    public void match_2개_테스트() {
        assertThat(winningLotto.match(Lotto.of(1, 2, 8, 9, 10, 11))).isEqualTo(Rank.MISS);
    }

    @Test
    public void match_보너스포함_4개() {
        assertThat(winningLotto.match(Lotto.of(1, 2, 3, 7, 8, 9))).isEqualTo(Rank.FIFTH);
    }
}
