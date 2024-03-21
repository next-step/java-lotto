package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @DisplayName("일치하는 갯수에 대한 랭킹을 구한다.")
    @Test
    void test01() {
        // given
        int size = 6;

        // when
        Rank rank = Rank.of(size);

        // then
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @DisplayName("당첨금을 구한다.")
    @Test
    void test02() {
        // given
        Rank rank = Rank.FOURTH;

        // when
        int result = rank.prizeMoney(2);

        // then
        assertThat(result).isEqualTo(100000);
    }

    @DisplayName("2등 랭킹을 구한다.")
    @Test
    void test03() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        int bonusNumber = 6;

        // when
        Rank rank = Rank.of(lotto, winningLotto, bonusNumber);

        // then
        assertThat(rank).isEqualTo(Rank.SECOND);
    }
}
