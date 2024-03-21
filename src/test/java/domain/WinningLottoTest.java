package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @DisplayName("랭킹 2등을 구한다.")
    @Test
    void test01() {
        // given
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 7), 6);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        Rank rank = winningLotto.rank(lotto);

        // then
        assertThat(rank).isEqualTo(Rank.SECOND);
    }
}
