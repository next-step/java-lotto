package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class WinningLottoTest {

    @Test
    @DisplayName("보너스 번호는 당첨번호와 달라야한다")
    void bonusNumberCheck_duplicate() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(1, 2, 3, 4, 5, 6), 6)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("5개 번호 = 3등")
    void match_rank_third() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(1, 2, 3, 4, 5, 6), 7);
        Lotto userLotto = new Lotto(1, 2, 3, 4, 5, 8);

        Rank rank = winningLotto.match(userLotto);
        Assertions.assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("5개 번호 + 보너스 번호 = 2등")
    void match_rank_second() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(1, 2, 3, 4, 5, 6), 7);
        Lotto userLotto = new Lotto(1, 2, 3, 4, 5, 7);

        Rank rank = winningLotto.match(userLotto);
        Assertions.assertThat(rank).isEqualTo(Rank.SECOND);
    }
}