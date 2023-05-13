package lotto.domain;

import lotto.domain.enums.LottoRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoRankTest {

    @Test
    void 생성자테스트 () {
        Assertions.assertThat(LottoRank.FIFTH.getPrizeMoney()).isEqualTo(5000);
        Assertions.assertThat(LottoRank.FIFTH.getMatchedCount()).isEqualTo(3);
    }

    @DisplayName("당첨등수찾기")
    @ParameterizedTest(name = "{displayName} [{index}] {arguments}")
    @CsvSource(value = {"1,false,0", "2,false,0", "3,false,5000", "4,false,50000", "5,false,1500000", "5,true,30000000", "6,false,2000000000"})
    void 당첨등수찾기(String matchedCount, String bonusMatched, String prizeMoney) {
        Assertions.assertThat(LottoRank.findByMatchedCount(Integer.parseInt(matchedCount),
                        Boolean.valueOf(bonusMatched)).getPrizeMoney())
                .isEqualTo(Integer.parseInt(prizeMoney));
    }

}
