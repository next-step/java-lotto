package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class LotteryRankTest {

    @DisplayName("로또 당첨번호 일치 개수와 보너스 번호 포함 여부를 인자로 받아 조건에 맞는 LotteryRank를 반환한다.")
    @ParameterizedTest
    @CsvSource({"6,false,FIRST", "5,true,SECOND", "5,false,THIRD", "4,false,FOURTH"})
    void findRank(int matchingCount, boolean bonus, LotteryRank expectedRank) {
        assertThat(LotteryRank.findRankBy(matchingCount, bonus)).isEqualTo(expectedRank);
    }
}