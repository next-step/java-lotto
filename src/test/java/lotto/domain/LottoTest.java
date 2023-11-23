package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Test
    void 생성() {
        Lotto lotto = new Lotto();
        assertThat(lotto.lotto()).hasSize(6);
    }

    @Test
    void 정렬() {
        Lotto lotto = new Lotto();
        assertThat(lotto.lotto()).isSorted();
    }

    @Test
    @DisplayName("ranking_winningLotto와 3개 일치하는 로또_Ranking.FIFTH")
    void fifth_winner() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 11, 12, 13));
        lotto.rank(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(lotto.ranking()).isEqualTo(Ranking.FIFTH);
    }

    @Test
    @DisplayName("ranking_winningLotto와 4개 일치하는 로또_Ranking.FOURTH")
    void fourth_winner() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 11, 12));
        lotto.rank(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(lotto.ranking()).isEqualTo(Ranking.FOURTH);
    }

    @Test
    @DisplayName("ranking_winningLotto와 5개 일치하는 로또_Ranking.THIRD")
    void third_winner() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 11));
        lotto.rank(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(lotto.ranking()).isEqualTo(Ranking.THIRD);
    }

    @Test
    @DisplayName("ranking_winningLotto와 6개 일치하는 로또_Ranking.FIRST")
    void first_winner() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lotto.rank(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(lotto.ranking()).isEqualTo(Ranking.FIRST);
    }
}