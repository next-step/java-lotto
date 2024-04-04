package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("당첨 개수 확인")
    void test01() {
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        Lotto winningLotto = new Lotto("1,2,3,4,5,6");

        assertThat(lotto.winningCount(winningLotto)).isEqualTo(6);
    }

    @Test
    @DisplayName("당첨 금액 확인 - 6개")
    void test02() {
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        Lotto winningLotto = new Lotto("1,2,3,4,5,6");
        assertThat(winningLotto.getReward(lotto)).isEqualTo(2000000000);
    }

    @Test
    @DisplayName("당첨 금액 확인 - 3개")
    void test03() {
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        Lotto winningLotto = new Lotto("1,2,3,7,8,9");
        assertThat(winningLotto.getReward(lotto)).isEqualTo(5000);
    }

    @Test
    @DisplayName("당첨 금액 확인 - 6개")
    void test04() {
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        Lotto winningLotto = new Lotto("1,2,3,4,5,6");
        assertThat(winningLotto.getRank(lotto)).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("당첨 금액 확인 - 3개")
    void test05() {
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        Lotto winningLotto = new Lotto("1,2,3,7,8,9");
        assertThat(winningLotto.getRank(lotto)).isEqualTo(Rank.FOURTH);
    }
}
