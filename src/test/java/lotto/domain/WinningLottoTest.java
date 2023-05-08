package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningLottoTest {
    @Test
    @DisplayName("주어진 로또와 일치하는 숫자 개수를 반환한다")
    void 일치_숫자_비교() {
        WinningLotto winningLotto = new WinningLotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)), 7);

        Lotto lotto_match0 = new Lotto(new ArrayList<>(Arrays.asList(7,8,9,10,11,12)));
        Lotto lotto_match3 = new Lotto(new ArrayList<>(Arrays.asList(1,2,3,7,8,9)));
        Lotto lotto_match6 = new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));

        assertThat(winningLotto.countMatchingWith(lotto_match0)).isEqualTo(0);
        assertThat(winningLotto.countMatchingWith(lotto_match3)).isEqualTo(3);
        assertThat(winningLotto.countMatchingWith(lotto_match6)).isEqualTo(6);
    }

    @Test
    @DisplayName("주어진 로또가 보너스볼 번호를 가지고 있는지 반환한다")
    void name() {
        WinningLotto winningLotto = new WinningLotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)), 7);
        Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,7)));

        assertThat(winningLotto.containsBonus(lotto)).isTrue();
    }
}
