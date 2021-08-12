package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    private Lotto win;
    private Lottos lottos;

    @BeforeEach
    void setup() {
        win = new Lotto(Arrays.asList(1, 4, 5, 6, 7, 23));
        lottos = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), // 3
                new Lotto(Arrays.asList(4, 5, 6, 7, 9, 23)), // 2
                new Lotto(Arrays.asList(8, 9, 10, 11, 12, 14, 15))));
    }

    @DisplayName("로또 2개 구입")
    @Test
    void create() {
        Lotto one = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto two = new Lotto(Arrays.asList(7, 8, 9, 10, 12, 13));

        assertThat(new Lottos(Arrays.asList(one, two)).getValue())
                .contains(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        new Lotto(Arrays.asList(7, 8, 9, 10, 12, 13)));
    }


    @DisplayName("로또 랭크 구하기")
    @Test
    void findRank() {
        assertThat(new Lottos(Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))))
                .findRankCount(win, Rank.FIRST)).isEqualTo(0);
        assertThat(new Lottos(Arrays.asList(new Lotto(Arrays.asList(1, 23, 4, 5, 6, 7))))
                .findRankCount(win, Rank.FIRST)).isEqualTo(1);
    }

    @DisplayName("로또 총 수입 구하기")
    @Test
    void totalEarnings() {
        assertThat(lottos.totalEarnings(win))
                .isEqualTo(Rank.SECOND.getRewards() + Rank.THIRD.getRewards());
    }

    @DisplayName("총 수익률 구하기")
    @Test
    void calculate() {
        int money = 2000 * lottos.getValue().size();
        assertThat(lottos.calculateProfit(win, money))
                .isEqualTo((double) (Rank.SECOND.getRewards() + Rank.THIRD.getRewards()) / (double) money);
    }
}