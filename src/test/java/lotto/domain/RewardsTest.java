package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RewardsTest {
    @ParameterizedTest
    @CsvSource(value = {"3:FOURTH:5000", "4:THIRD:50000", "5:SECOND:1500000", "6:FIRST:2000000000",}, delimiter = ':')
    @DisplayName("당첨 숫자 갯수에 맞는 당첨 순위 가져오기")
    public void getRewardsTest(int matches, String place, int prize) {
        assertThat(LottoRank.getLottoRank(matches).toString()).isEqualTo(place);
        assertThat(LottoRank.getLottoRank(matches).getPrize()).isEqualTo(prize);
    }

    @Test
    @DisplayName("상금 범위 이외의 당첨 숫자에 대해 낙첨 결과 가져오기")
    public void getRewardsRangeErrorTest() {
        assertThat(LottoRank.getLottoRank(0)).isEqualTo(LottoRank.LOSE);
    }

    @Test
    @DisplayName("전체 상금 계산 테스트")
    public void getWholePrizeTest() {
        Map<LottoRank, Long> result = new HashMap<>();

        result.put(LottoRank.FOURTH, 4L);
        result.put(LottoRank.THIRD, 0L);
        result.put(LottoRank.SECOND, 1L);
        result.put(LottoRank.FIRST, 1L);

        assertThat(LottoRank.getWholePrize(result)).isEqualTo(2_001_520_000);
    }
}