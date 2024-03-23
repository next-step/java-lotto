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
        Lotto lotto = new Lotto(createLottoNumbers(Set.of(1, 2, 3, 4, 5, 6)));

        assertThat(lotto).isEqualTo(new Lotto(createLottoNumbers(Set.of(1, 2, 3, 4, 5, 6))));
    }

    @DisplayName("랭킹을 구한다.")
    @Test
    void test02() {
        WinningLotto winningLotto = new WinningLotto(createLottoNumbers(Set.of(1, 2, 3, 4, 5, 7)), new LottoNumber(6));
        Lotto lotto = new Lotto(createLottoNumbers(Set.of(1, 2, 3, 4, 5, 6)));

        Rank rank = lotto.rank(winningLotto);

        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    private static LottoNumbers createLottoNumbers(Set<Integer> numbers) {
        Set<LottoNumber> result = new HashSet<>();
        for (Integer number : numbers) {
            result.add(new LottoNumber(number));
        }
        return new LottoNumbers(result);
    }
}
