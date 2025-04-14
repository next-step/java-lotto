package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class LottoWinningRecordTest {

    @Test
    @DisplayName("수익률을 정확히 계산한다")
    void calculateTotalPrizeRatio() {
        Map<LottoRank, Integer> rankMap = new EnumMap<>(LottoRank.class);
        rankMap.put(LottoRank.MATCH_3, 2); // 2 * 5000 = 10000원 당첨
        rankMap.put(LottoRank.NO_MATCH, 1);

        LottoWinningRecord record = new LottoWinningRecord(rankMap);

        double ratio = record.totalLottoPrizeRatio(5000); // 5000원 투자
        assertThat(ratio).isEqualTo(2.0); // 10000 / 5000 = 2.0
    }

    @Test
    @DisplayName("지출이 0이면 수익률은 0이다")
    void zeroSpentReturnsZeroRatio() {
        Map<LottoRank, Integer> rankMap = new EnumMap<>(LottoRank.class);
        rankMap.put(LottoRank.MATCH_3, 1);

        LottoWinningRecord record = new LottoWinningRecord(rankMap);

        double ratio = record.totalLottoPrizeRatio(0);
        assertThat(ratio).isEqualTo(0.0);
    }
}

