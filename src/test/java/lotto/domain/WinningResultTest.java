package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.domain.LottoRank.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

class WinningResultTest {

    @Test
    void create() {
        List<LottoRank> staticsList = Arrays.asList(MISS, MISS, THIRD);
        WinningResult result = new WinningResult(staticsList);
        assertThat(new WinningResult(MISS, MISS, THIRD, THIRD)).isEqualTo(result);
    }

    @Test
    void 통계정보반영_3등_5등() {
        WinningResult result = new WinningResult();
        result.incrementMatchCount(FIFTH);
        result.incrementMatchCount(THIRD);
        assertThat(result).isEqualTo(new WinningResult(FIFTH, THIRD));
    }

    @Test
    @DisplayName("3등 1개 (5_000원) / 구입금액 = 1_000_000")
    void 수익률_계산() {
        WinningResult result = new WinningResult(FIFTH);
        assertThat(result.calculateProfitRate(1_000_000)).isCloseTo(0.005, within(0.001));
    }
}
