package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName("로또를 발급한다.")
    @Test
    void test01() {
        Lotto lotto = createLotto(Set.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto).isEqualTo(createLotto(Set.of(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("랭킹을 구한다.")
    @Test
    void test02() {
        WinningLotto winningLotto = new WinningLotto(createLotto(Set.of(1, 2, 3, 4, 5, 7)), new LottoNumber(6));
        Lotto lotto = createLotto(Set.of(1, 2, 3, 4, 5, 6));

        Rank rank = lotto.rank(winningLotto);

        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("일치하는 갯수를 구한다.")
    @Test
    void test03() {
        Lotto lotto = createLotto(Set.of(1, 2, 3, 4, 5, 6));

        int result = lotto.matchCount(createLotto(Set.of(1, 2, 3, 10, 11, 12)));

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("2등 조건(5개와 보너스 번호 매치)과 매치하는지 구한다.")
    @Test
    void test04() {
        Lotto lotto = createLotto(Set.of(1, 2, 3, 4, 5, 6));

        boolean result = lotto.isMatchFiveNumberAndBonusNumber(createLotto(Set.of(1, 2, 3, 4, 5, 7)), new LottoNumber(6));

        assertThat(result).isTrue();
    }

    private static Lotto createLotto(Set<Integer> numbers) {
        Set<LottoNumber> result = new HashSet<>();
        for (Integer number : numbers) {
            result.add(new LottoNumber(number));
        }
        return new Lotto(result);
    }
}
