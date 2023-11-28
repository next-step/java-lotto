package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    private final Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @Test
    void 생성() {
        RandomLottoNumbers randomLottoNumbers = new RandomLottoNumbers();
        Lotto lotto = new Lotto(randomLottoNumbers.lottoNumbers());
        assertThat(lotto.lotto()).hasSize(6);
    }

    @Test
    @DisplayName("matchingCount_winningLotto와 3개 일치하는 로또_Ranking.FIFTH")
    void fifth_winner() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 11, 12, 13));
        assertThat(lotto.matchingCount(winningLotto)).isEqualTo(Ranking.FIFTH.matchingCount());
    }

    @Test
    @DisplayName("matchingCount_winningLotto와 4개 일치하는 로또_Ranking.FOURTH")
    void fourth_winner() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 11, 12));
        assertThat(lotto.matchingCount(winningLotto)).isEqualTo(Ranking.FOURTH.matchingCount());
    }

    @Test
    @DisplayName("matchingCount_winningLotto와 5개 일치하는 로또_Ranking.THIRD")
    void third_winner() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 11));
        assertThat(lotto.matchingCount(winningLotto)).isEqualTo(Ranking.THIRD.matchingCount());
    }

    @Test
    @DisplayName("matchingCount_winningLotto와 6개 일치하는 로또_Ranking.FIRST")
    void first_winner() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.matchingCount(winningLotto)).isEqualTo(Ranking.FIRST.matchingCount());
    }

    @Test
    @DisplayName("ranking_일반 번호 5개와 보너스 번호 1개가 일치하는 winningLotto_2등")
    void ranking() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.ranking(new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 8)), 6))).isEqualTo(Ranking.SECOND);
    }
}