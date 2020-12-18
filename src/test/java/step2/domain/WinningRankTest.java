package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningRankTest {
    @DisplayName("당첨번호 횟수에 따른 상금 여부")
    @ParameterizedTest
    @CsvSource(value = {"3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    public void validateGetPrize(long matchingCount, long prize) {
        assertThat(WinningRank.findRanking(matchingCount).getPrizeMoney()).isEqualTo(prize);
    }

    @DisplayName("rank에 따른 개수 확인 테스트")
    @Test
    void countOfMatch() {
        assertThat(WinningRank.getMatchingCount(WinningRank.FIRST)).isEqualTo(6);
        assertThat(WinningRank.getMatchingCount(WinningRank.SECOND)).isEqualTo(5);
        assertThat(WinningRank.getMatchingCount(WinningRank.THIRD)).isEqualTo(4);
        assertThat(WinningRank.getMatchingCount(WinningRank.FOURTH)).isEqualTo(3);
    }
}