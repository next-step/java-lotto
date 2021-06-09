package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultTest {
    @DisplayName("로또 1등을 찾을 수 있다.")
    @Test
    void findRankFirst() {
        assertThat(Rank.findLottoRank(6, false))
                .isEqualTo(Rank.FIRST_PLACE);
    }

    @DisplayName("로또 2등을 찾을 수 있다.")
    @Test
    void findRankSecond() {
        assertThat(Rank.findLottoRank(5, true))
                .isEqualTo(Rank.SECOND_PLACE);
    }

    @DisplayName("로또 3등을 찾을 수 있다.")
    @Test
    void findRankThird() {
        assertThat(Rank.findLottoRank(5, false))
                .isEqualTo(Rank.THIRD_PLACE);
    }

    @DisplayName("로또 4등을 찾을 수 있다.")
    @Test
    void findRankFourth() {
        assertThat(Rank.findLottoRank(4, false))
                .isEqualTo(Rank.FOURTH_PLACE);
    }

    @DisplayName("로또 5등을 찾을 수 있다.")
    @Test
    void findRankFifth() {
        assertThat(Rank.findLottoRank(3, false))
                .isEqualTo(Rank.FIFTH_PLACE);
    }

    @DisplayName("로또 6등을 찾을 수 있다.")
    @Test
    void findRankElse() {
        assertThat(Rank.findLottoRank(0, false))
                .isEqualTo(Rank.NOT_IN_RANK);
    }

    @DisplayName("로또의 수익률을 계산할 수 있다.")
    @Test
    void calculateYieldTest() {
        double yield = Math.floor(((double) 5000 / (double) 14000) * 100)
                / 100;
        assertThat(yield).isEqualTo(0.35);
    }
}
