package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    void 로또_생성() {
        Lotto lotto = new Lotto(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)));

        assertThat(lotto).isEqualTo(new Lotto("1, 2, 3, 4, 5, 6"));
    }

    @Test
    void 로또_6자리_검증() {
        assertThatThrownBy(() -> {
            new Lotto(1, 2, 3, 4, 5, 5);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_오름차순_정렬() {
        Lotto lotto = new Lotto(6, 5, 4, 3, 2, 1);
        assertThat(lotto).isEqualTo(new Lotto(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 등수_반환() {
        Lotto lastWinningLotto = new Lotto(1, 2, 3, 4, 5, 6);
        int bonusNumber = 45;

        Lotto lotto1 = new Lotto(1, 2, 3, 4, 5, 6);
        assertThat(lotto1.determineRank(lastWinningLotto, bonusNumber)).isEqualTo(LottoRank.FIRST);

        Lotto Lotto = new Lotto(1, 2, 3, 4, 5, 45);
        assertThat(Lotto.determineRank(lastWinningLotto, bonusNumber)).isEqualTo(LottoRank.SECOND);

        Lotto lotto3 = new Lotto(1, 2, 3, 4, 5, 7);
        assertThat(lotto3.determineRank(lastWinningLotto, bonusNumber)).isEqualTo(LottoRank.THIRD);

        Lotto lotto4 = new Lotto(1, 2, 3, 4, 7, 8);
        assertThat(lotto4.determineRank(lastWinningLotto, bonusNumber)).isEqualTo(LottoRank.FOURTH);

        Lotto lotto5 = new Lotto(1, 2, 3, 7, 8, 9);
        assertThat(lotto5.determineRank(lastWinningLotto, bonusNumber)).isEqualTo(LottoRank.FIFTH);

        Lotto lotto6 = new Lotto(1, 2, 7, 8, 9, 10);
        assertThat(lotto6.determineRank(lastWinningLotto, bonusNumber)).isEqualTo(LottoRank.ETC);

        Lotto lotto7 = new Lotto(1, 7, 8, 9, 10, 11);
        assertThat(lotto7.determineRank(lastWinningLotto, bonusNumber)).isEqualTo(LottoRank.ETC);

        Lotto lotto8 = new Lotto(7, 8, 9, 10, 11, 12);
        assertThat(lotto8.determineRank(lastWinningLotto, bonusNumber)).isEqualTo(LottoRank.ETC);
    }
}
