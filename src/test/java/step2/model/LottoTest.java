package step2.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import step2.model.Lotto;

public class LottoTest {

    @Test
    public void 우승로또와_비교하여_같은_개수_0개_케이스_테스트() {
        Lotto myLotto = new Lotto(new int[]{1, 2, 3, 4, 5, 6});
        Lotto winnerLotto = new Lotto(new int[]{7, 8, 9, 10, 11, 12});

        assertThat(myLotto.compareToMatchNumberCount(winnerLotto)).isEqualTo(0);
    }

    @Test
    public void 우승로또와_비교하여_같은_개수_6개_케이스_테스트() {
        Lotto myLotto = new Lotto(new int[]{1, 2, 3, 4, 5, 6});
        Lotto winnerLotto = new Lotto(new int[]{1, 2, 3, 4, 5, 6});

        assertThat(myLotto.compareToMatchNumberCount(winnerLotto)).isEqualTo(6);
    }
}
