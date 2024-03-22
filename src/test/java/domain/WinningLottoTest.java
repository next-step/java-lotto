package domain;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @DisplayName("랭킹 2등을 구한다.")
    @Test
    void test01() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 7), 6);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Rank rank = winningLotto.rank(lotto);

        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("랭킹을 구한다.")
    @Test
    void test02() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));

        Rank rank = winningLotto.rank(lotto);

        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @DisplayName("로또 여러 개에 대한 랭킹을 구한다.")
    @Test
    void test03() {
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 10, 11));
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 10, 11));
        Lotto lotto5 = new Lotto(List.of(1, 2, 3, 4, 10, 11));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3, lotto4, lotto5));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        Ranks ranks = winningLotto.ranks(lottos);

        assertThat(ranks.totalPrizeMoney()).isEqualTo(60_150_000);
    }
}
