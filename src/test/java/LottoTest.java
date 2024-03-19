import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName("로또를 발급한다.")
    @Test
    void test01() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        Lotto lotto = new Lotto(numbers);

        // then
        assertThat(lotto.numbers()).isEqualTo(numbers);
    }

    @DisplayName("랭킹을 구한다.")
    @Test
    void test02() {
        // given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        Rank rank = lotto.rank(winningLotto);

        // then
        assertThat(rank).isEqualTo(Rank.FIRST);
    }
}
