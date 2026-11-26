package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoResultTest {

    private static final WinningLotto WINNING = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));

    @DisplayName("상금별로 몇 장이 당첨됐는지 센다")
    @Test
    void countOf() {
        LottoResult result = new LottoResult(List.of(
                new Lotto(List.of(1, 2, 3, 10, 11, 12)),
                new Lotto(List.of(1, 2, 3, 20, 21, 22)),
                new Lotto(List.of(1, 2, 3, 4, 11, 12)),
                new Lotto(List.of(40, 41, 42, 43, 44, 45))), WINNING);

        assertThat(result.countOf(Prize.FOURTH)).isEqualTo(2);
        assertThat(result.countOf(Prize.THIRD)).isEqualTo(1);
        assertThat(result.countOf(Prize.NONE)).isEqualTo(1);
    }

    @DisplayName("당첨된 로또가 없는 상금은 0이다")
    @Test
    void countOfNotWonPrize() {
        LottoResult result = new LottoResult(
                List.of(new Lotto(List.of(40, 41, 42, 43, 44, 45))), WINNING);

        assertThat(result.countOf(Prize.FIRST)).isZero();
        assertThat(result.countOf(Prize.SECOND)).isZero();
        assertThat(result.countOf(Prize.THIRD)).isZero();
        assertThat(result.countOf(Prize.FOURTH)).isZero();
    }
}
