package step3;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @Test
    @DisplayName("로또 결과 테스트")
    void result() {
        Lotto ex1 = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        Lotto ex2 = new Lotto(Set.of(1, 2, 3, 4, 5, 9));
        Lotto exBonus = new Lotto(Set.of(1, 2, 3, 4, 5, 7));

        Lotto winningLotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        int bonus = 7;

        BonusLotto bonusLotto = new BonusLotto(winningLotto, bonus);

        Lottos lottos = new Lottos(Arrays.asList(ex1, ex2, exBonus));

        assertThat(lottos.results(ex1, bonusLotto)).isEqualTo(6);
        assertThat(lottos.results(ex2, bonusLotto)).isEqualTo(5);
        assertThat(lottos.results(exBonus, bonusLotto)).isEqualTo(5);
    }
}
