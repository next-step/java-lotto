package step2.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    public void 우승로또와_보너스번호가_같은_경우에_예외_반환_테스트() {
        assertThatThrownBy(() -> new WinningLotto(new int[]{1, 2, 3, 4, 5, 6}, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    public void 우승로또와_비교하여_같은_개수_0개_케이스_테스트() {
        Lotto myLotto = new Lotto(new int[]{1, 2, 3, 4, 5, 6});
        WinningLotto winningLotto = new WinningLotto(new int[]{7, 8, 9, 10, 11, 12}, 13);

        assertThat(winningLotto.compareToMatchNumberCount(myLotto)).isEqualTo(0);
    }

    @Test
    public void 우승로또와_비교하여_같은_개수_2등_케이스_테스트() {
        Lotto myLotto = new Lotto(new int[]{1, 2, 3, 4, 5, 6});
        WinningLotto winningLotto = new WinningLotto(new int[]{1, 2, 3, 4, 5, 7}, 6);

        assertThat(winningLotto.compareToMatchNumberCount(myLotto)).isEqualTo(5);
    }

    @Test
    public void 구매한로또와_우승자로또의_일치하는_번호_개수_반환_테스트() {
        WinningLotto winningLotto = new WinningLotto(new int[]{1, 2, 3, 4, 5, 6}, 7);
        Lotto myLotto = new Lotto(new int[]{1, 2, 3, 10, 11, 12});

        assertThat(winningLotto.compareToMatchNumberCount(myLotto)).isEqualTo(3);
    }

    @Test
    public void 구매한로또와_우승자로또의_보너스번호_일치여부_반환_테스트() {
        WinningLotto winningLotto = new WinningLotto(new int[]{1, 2, 3, 4, 5, 6}, 7);
        Lotto myLotto = new Lotto(new int[]{1, 2, 3, 4, 5, 7});

        assertThat(winningLotto.checkBonusNumber(myLotto)).isTrue();
    }
}
