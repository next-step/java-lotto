package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;


class LottosTest {

    @Test
    void countMatching() {
        Lottos lottos = getLottos();
        Lotto winningLotto = new Lotto(1, 2, 3, 4, 5, 6);

        RankResult rankResult = lottos.countMatching(new WinningLotto(winningLotto, new LottoNumber(7)));
        assertThat(rankResult).isEqualTo(RankResultTest.getRankResult());
    }

    @Test
    void size() {
        Lottos lottos = getLottos();
        assertThat(lottos.size()).isEqualTo(5);
    }

    @Test
    void addAll() {
        Lottos lottos1 = getLottos();
        Lottos lottos2 = getLottos();
        Lottos actual = lottos1.addAll(lottos2);
        Lottos expect = getAddAllLottos();

        assertThat(actual).isEqualTo(expect);
    }

    private static Lottos getAddAllLottos() {
        return new Lottos(List.of(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(2, 3, 4, 5, 6, 7),
                new Lotto(2, 3, 4, 5, 6, 9),
                new Lotto(3, 4, 5, 6, 7, 8),
                new Lotto(4, 5, 6, 7, 8, 9),
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(2, 3, 4, 5, 6, 7),
                new Lotto(2, 3, 4, 5, 6, 9),
                new Lotto(3, 4, 5, 6, 7, 8),
                new Lotto(4, 5, 6, 7, 8, 9)));
    }

    public static Lottos getLottos() {
        return new Lottos(List.of(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(2, 3, 4, 5, 6, 7),
                new Lotto(2, 3, 4, 5, 6, 9),
                new Lotto(3, 4, 5, 6, 7, 8),
                new Lotto(4, 5, 6, 7, 8, 9)));
    }
}