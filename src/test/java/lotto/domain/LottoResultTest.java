package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoResultTest {

    @DisplayName("일치 개수별 로또 장수를 알 수 있다. (3개 일치 1장 → 1, 4개 일치 없음 → 0)")
    @Test
    public void test_1() {
        LottoResult result = new LottoResult(List.of(Prize.THREE));

        assertThat(result.countOf(Prize.THREE)).isEqualTo(1);
        assertThat(result.countOf(Prize.FOUR)).isEqualTo(0);
    }

    @DisplayName("총 상금을 알 수 있다. (3개 일치 1장 → 5000원)")
    @Test
    public void test_2() {
        LottoResult result = new LottoResult(List.of(Prize.THREE));

        assertThat(result.totalPrize()).isEqualTo(5_000L);
    }

    @DisplayName("총 상금은 long으로 계산한다. (6개 일치 2장 → 4000000000원)")
    @Test
    public void test_3() {
        LottoResult result = new LottoResult(List.of(Prize.SIX, Prize.SIX));

        assertThat(result.totalPrize()).isEqualTo(4_000_000_000L);
    }

    @DisplayName("수익률은 총 상금 / (구입 장수 × 1000) (5000 / 14000 → 0.35, 버림)")
    @Test
    public void test_4() {
        List<Prize> prizes = new ArrayList<>(Collections.nCopies(13, Prize.NONE));
        prizes.add(Prize.THREE);
        LottoResult result = new LottoResult(prizes);

        assertThat(result.profitRate()).isEqualTo(0.35);
    }

    @DisplayName("당첨이 없을 때 수익률 (0원 → 0.0)")
    @Test
    public void test_5() {
        LottoResult result = new LottoResult(List.of(Prize.NONE));

        assertThat(result.profitRate()).isEqualTo(0.0);
    }

    @DisplayName("등수 목록이 비어 있으면 예외 ([] → 실패)")
    @Test
    public void test_6() {
        assertThatThrownBy(() -> new LottoResult(List.of()))
                .isInstanceOf(RuntimeException.class);
    }
}
