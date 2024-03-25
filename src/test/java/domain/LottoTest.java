package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName("로또를 발급한다.")
    @Test
    void test01() {
        Lotto lotto = createLotto(Set.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto).isEqualTo(createLotto(Set.of(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("로또 발급 시 번호 갯수가 중복없이 6개가 아닌 경우 예외가 발생한다.")
    @Test
    void test02() {
        assertThatThrownBy(() -> createLotto(Set.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호의 갯수가 6개가 아닙니다.");
    }

    @DisplayName("랭킹을 구한다.")
    @Test
    void test03() {
        WinningLotto winningLotto = new WinningLotto(createLotto(Set.of(1, 2, 3, 4, 5, 7)), new LottoNumber(6));
        Lotto lotto = createLotto(Set.of(1, 2, 3, 4, 5, 6));

        Rank rank = lotto.rank(winningLotto);

        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("일치하는 갯수를 구한다.")
    @Test
    void test04() {
        Lotto lotto = createLotto(Set.of(1, 2, 3, 4, 5, 6));

        int result = lotto.matchCount(createLotto(Set.of(1, 2, 3, 10, 11, 12)));

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("2등 조건(5개와 보너스 번호 매치)과 매치하는지 구한다.")
    @Test
    void test05() {
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
