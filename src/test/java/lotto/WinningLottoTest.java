package lotto;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @Test
    @DisplayName("당첨 개수 확인")
    void test01() {
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        Lotto winningLotto = new Lotto("1,2,3,4,5,6");

        assertThat(lotto.winningCount(winningLotto)).isEqualTo(6);
    }

    @Test
    @DisplayName("당첨 금액 확인 - 1등")
    void test02() {
        Lotto lotto = new Lotto("1,4,5,6,7,8");
        int bonusNumber = 8;
        WinningLotto winningLotto = new WinningLotto(List.of(1, 4, 5, 6, 7, 8), bonusNumber);
        assertThat(winningLotto.getReward(lotto)).isEqualTo(2000000000);
        assertThat(winningLotto.getRank(lotto)).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("당첨 금액 확인 - 2등")
    void test03() {
        Lotto lotto = new Lotto("1,4,5,6,7,9");
        int bonusNumber = 9;
        WinningLotto winningLotto = new WinningLotto(List.of(1, 4, 5, 6, 7, 8), bonusNumber);
        assertThat(winningLotto.getReward(lotto)).isEqualTo(30000000);
        assertThat(winningLotto.getRank(lotto)).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("당첨 금액 확인 - 3등")
    void test04() {
        Lotto lotto = new Lotto("1,4,5,6,7,10");
        int bonusNumber = 9;
        WinningLotto winningLotto = new WinningLotto(List.of(1, 4, 5, 6, 7, 8), bonusNumber);
        assertThat(winningLotto.getReward(lotto)).isEqualTo(1500000);
        assertThat(winningLotto.getRank(lotto)).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("당첨 금액 확인 - 4등")
    void test05() {
        Lotto lotto = new Lotto("1,4,5,6,10,11");
        int bonusNumber = 9;
        WinningLotto winningLotto = new WinningLotto(List.of(1, 4, 5, 6, 7, 8), bonusNumber);
        assertThat(winningLotto.getReward(lotto)).isEqualTo(50000);
        assertThat(winningLotto.getRank(lotto)).isEqualTo(Rank.FOURTH);
    }
}
