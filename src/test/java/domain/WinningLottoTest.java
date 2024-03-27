package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @DisplayName("입력으로 들어온 하나의 로또와 비교하여 랭킹을 구한다.")
    @Test
    void test01() {
        WinningLotto winningLotto = new WinningLotto(TestFixture.createLotto(Set.of(1, 2, 3, 4, 5, 7)), new LottoNumber(6));

        Rank rank = winningLotto.rank(TestFixture.createLotto(Set.of(1, 2, 3, 4, 5, 6)));

        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("입력으로 들어온 여러 개의 로또와 비교하여 전체 랭킹을 구한다.")
    @Test
    void test02() {
        Lotto lotto2 = TestFixture.createLotto(Set.of(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = TestFixture.createLotto(Set.of(1, 2, 3, 4, 5, 7));
        Lotto lotto1 = TestFixture.createLotto(Set.of(1, 2, 3, 4, 10, 11));
        Lotto lotto4 = TestFixture.createLotto(Set.of(1, 2, 3, 4, 10, 11));
        Lotto lotto5 = TestFixture.createLotto(Set.of(1, 2, 3, 4, 10, 11));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3, lotto4, lotto5));
        WinningLotto winningLotto = new WinningLotto(TestFixture.createLotto(Set.of(1, 2, 3, 4, 5, 6)), new LottoNumber(7));

        Ranks ranks = winningLotto.ranks(lottos);

        assertThat(ranks.totalCount()).isEqualTo(5);
    }
}
