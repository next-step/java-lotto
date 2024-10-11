package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoRankingEnumTest {
    @Test
    void getEnumByMatchCnt() {
        assertThat(LottoRankingEnum.getEnumByMatchCount(2)).isEqualTo(LottoRankingEnum.LOSING_LOT);
        assertThat(LottoRankingEnum.getEnumByMatchCount(6)).isEqualTo(LottoRankingEnum.FIRST_PRIZE);
    }
}
