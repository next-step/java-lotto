package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoResultTest {

    private static final WinningLotto WINNING = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
    private static final List<Integer> MISSED = List.of(40, 41, 42, 43, 44, 45);

    @DisplayName("상금별로 몇 장이 당첨됐는지 센다")
    @Test
    void countOf() {
        LottoResult result = new LottoResult(List.of(
                new Lotto(List.of(1, 2, 3, 10, 11, 12)),
                new Lotto(List.of(1, 2, 3, 20, 21, 22)),
                new Lotto(List.of(1, 2, 3, 4, 11, 12)),
                new Lotto(MISSED)), WINNING, 4000);

        assertThat(result.countOf(Prize.FOURTH)).isEqualTo(2);
        assertThat(result.countOf(Prize.THIRD)).isEqualTo(1);
        assertThat(result.countOf(Prize.NONE)).isEqualTo(1);
    }

    @DisplayName("당첨된 로또가 없는 상금은 0이다")
    @Test
    void countOfNotWonPrize() {
        LottoResult result = new LottoResult(List.of(new Lotto(MISSED)), WINNING, 1000);

        assertThat(result.countOf(Prize.FIRST)).isZero();
        assertThat(result.countOf(Prize.SECOND)).isZero();
        assertThat(result.countOf(Prize.THIRD)).isZero();
        assertThat(result.countOf(Prize.FOURTH)).isZero();
    }

    @DisplayName("당첨 금액의 합을 구한다")
    @Test
    void totalPrize() {
        LottoResult result = new LottoResult(List.of(
                new Lotto(List.of(1, 2, 3, 10, 11, 12)),
                new Lotto(List.of(1, 2, 3, 4, 11, 12)),
                new Lotto(MISSED)), WINNING, 3000);

        assertThat(result.totalPrize()).isEqualTo(55_000L);
    }

    @DisplayName("1등이 두 장이어도 상금 합이 넘치지 않는다")
    @Test
    void totalPrizeOverIntRange() {
        LottoResult result = new LottoResult(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6))), WINNING, 2000);

        assertThat(result.totalPrize()).isEqualTo(4_000_000_000L);
    }

    @DisplayName("수익률은 소수점 셋째 자리에서 버린다")
    @Test
    void profitRate() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 10, 11, 12)));
        for (int i = 0; i < 13; i++) {
            lottos.add(new Lotto(MISSED));
        }

        LottoResult result = new LottoResult(lottos, WINNING, 14000);

        assertThat(result.profitRate()).isEqualTo(0.35);
    }

    @DisplayName("당첨이 없으면 수익률은 0이다")
    @Test
    void profitRateWithoutPrize() {
        LottoResult result = new LottoResult(List.of(new Lotto(MISSED)), WINNING, 1000);

        assertThat(result.profitRate()).isZero();
    }
}
