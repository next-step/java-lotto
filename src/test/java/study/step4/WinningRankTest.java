package study.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.step4.domain.WinningRank;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningRankTest {

    @ParameterizedTest
    @DisplayName("당첨번호 일치 횟수로 당첨금액 매칭 테스트")
    @CsvSource(value = {"3:5000:false", "4:50000:true", "5:1500000:false", "5:30000000:true", "6:2000000000:true"}, delimiter = ':')
    public void findRankingTest(long matchingCount, long prize, boolean matchBonus){
        assertThat(WinningRank.findRanking(matchingCount, matchBonus).getPrizeMoney())
                .isEqualTo(prize);
    }
}
