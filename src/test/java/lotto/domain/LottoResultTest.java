package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    private static final Lotto WINNING_LOTTO = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private static final Lotto THREE_MATCH_LOTTO = new Lotto(List.of(1, 2, 3, 7, 8, 9));
    private static final Lotto NO_MATCH_LOTTO = new Lotto(List.of(10, 11, 12, 13, 14, 15));

    @DisplayName("일치 개수별 로또 장수를 알 수 있다. (3개 일치 1장 → 1, 4개 일치 없음 → 0)")
    @Test
    public void test_1() {
        Lottos myLottos = new Lottos(List.of(THREE_MATCH_LOTTO));
        LottoResult result = new LottoResult(myLottos, WINNING_LOTTO);

        assertThat(result.countOf(Prize.THREE)).isEqualTo(1);
        assertThat(result.countOf(Prize.FOUR)).isEqualTo(0);
    }

    @DisplayName("총 상금을 알 수 있다. (3개 일치 1장 → 5000원)")
    @Test
    public void test_2() {
        Lottos myLottos = new Lottos(List.of(THREE_MATCH_LOTTO));
        LottoResult result = new LottoResult(myLottos, WINNING_LOTTO);

        assertThat(result.totalPrize()).isEqualTo(5_000L);
    }

    @DisplayName("총 상금은 long으로 계산한다. (6개 일치 2장 → 4000000000원)")
    @Test
    public void test_3() {
        Lottos myLottos = new Lottos(List.of(WINNING_LOTTO, WINNING_LOTTO));
        LottoResult result = new LottoResult(myLottos, WINNING_LOTTO);

        assertThat(result.totalPrize()).isEqualTo(4_000_000_000L);
    }

    @DisplayName("수익률은 총 상금 / (구입 장수 × 1000) (5000 / 14000 → 0.35, 버림)")
    @Test
    public void test_4() {
        List<Lotto> lottos = new ArrayList<>(Collections.nCopies(13, NO_MATCH_LOTTO));
        lottos.add(THREE_MATCH_LOTTO);
        LottoResult result = new LottoResult(new Lottos(lottos), WINNING_LOTTO);

        assertThat(result.profitRate()).isEqualTo(0.35);
    }

    @DisplayName("당첨이 없을 때 수익률 (0원 → 0.0)")
    @Test
    public void test_5() {
        Lottos myLottos = new Lottos(List.of(NO_MATCH_LOTTO));
        LottoResult result = new LottoResult(myLottos, WINNING_LOTTO);

        assertThat(result.profitRate()).isEqualTo(0.0);
    }
}
