package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.domain.LottoRank.*;
import static org.assertj.core.api.Assertions.assertThat;

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
    @DisplayName("3등 1개, 5등 1개 = 1505000원")
    void 당첨금액_계산() {
        WinningResult result = new WinningResult(THIRD, FIFTH);
        assertThat(result.calculateProfitRate()).isEqualTo(1505000);
    }
}
