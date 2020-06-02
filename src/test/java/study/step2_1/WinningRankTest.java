package study.step2_1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.step2_1.domain.WinningRank;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningRankTest {

    @ParameterizedTest
    @DisplayName("당첨번호 일치 횟수로 당첨금액 매칭 테스트")
    @CsvSource(value = {"3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    public void findRankingTest(long matchingCount, long prize){
        assertThat(WinningRank.findRanking(matchingCount).getPrizeMoney()).isEqualTo(prize);
    }
}
