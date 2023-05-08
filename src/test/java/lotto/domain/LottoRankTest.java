package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoRankTest {

    @Test
    void 생성자테스트 () {
        Assertions.assertThat(LottoRank.FOURTH.getPrizeMoney()).isEqualTo(5000);
        Assertions.assertThat(LottoRank.FOURTH.getMatchedCount()).isEqualTo(3);
    }

    @DisplayName("당첨등수찾기")
    @ParameterizedTest(name = "{displayName} [{index}] {arguments}")
    @CsvSource(value = {"1,0", "2,0", "3,5000", "4,50000", "5,1500000", "6,2000000000"})
    void 당첨등수찾기(String matchedCount, String prizeMoney) {
        Assertions.assertThat(LottoRank.findByMatchedCount(Integer.parseInt(matchedCount)).getPrizeMoney())
                .isEqualTo(Integer.parseInt(prizeMoney));
    }

}
