package lotto.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.domain.LottoResult;
import lotto.domain.WinningStatistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {

    List<LottoResult> results = new ArrayList<>();
    HashMap<LottoResult, Integer> result;

    @BeforeEach
    void setUp() {
        results.add(LottoResult.THREE_MATCHING);
        results.add(LottoResult.THREE_MATCHING);
        results.add(LottoResult.FOUR_MATCHING);
        result = WinningStatistics.getResult(results);
    }

    @Test
    void 종류별로_결과_개수_계산_정상출력() {
        assertThat(result.get(LottoResult.THREE_MATCHING)).isEqualTo(2);
        assertThat(result.get(LottoResult.FOUR_MATCHING)).isEqualTo(1);
        assertThat(result.get(LottoResult.FIVE_MATCHING_BONUS)).isEqualTo(null);
    }

    @Test
    void 반환된_로또_결과_수와_로또_구매_수량이_다르면_예외처리() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> WinningStatistics.getProfitRate(result, 2000))
            .withMessage("[ERROR] 반환된 로또 결과 수와 로또 구매 수량이 다릅니다.");

    }

    @Test
    void 수익률_계산_정상() {
        final int CORRECT_PURCHASE_PRICE = 3000;
        assertThat(WinningStatistics.getProfitRate(result, 3000)).isEqualTo("20.00");
    }
}
