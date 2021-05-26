package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import lotto.constant.LottoRank;

/**
 * 순위별 당첨된 로또 갯수를 관리하는 RankCounts 일급 컬렉션 테스트
 */
public class RankCountsTest {

    @ParameterizedTest
    @CsvSource(value = {"FIRST,5", "SECOND,2", "THIRD,1", "FOURTH,6", "OUT_OF_RANK,10"})
    @DisplayName("순위를 기준으로 담첨된 로또의 개수를 확인")
    void lottoCount_by_rank(LottoRank rank, int lottoCount) {
        // given
        Map<LottoRank, Integer> counts = new HashMap<>();
        counts.put(rank, lottoCount);
        RankCounts rankCounts = new RankCounts(counts);

        // when
        int resultLottoCount = rankCounts.getWinningLottoCount(rank);

        // then
        assertThat(resultLottoCount).isEqualTo(lottoCount);
    }
}
