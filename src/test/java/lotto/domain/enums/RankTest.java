package lotto.domain.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @DisplayName("총 금액은 당첨된 갯수 곱하기 상금이다")
    @Test
    void winningAmountByCount() {
        assertThat(Rank.FOURTH.winningAmountByCount(10)).isEqualTo(BigDecimal.valueOf(500_000L));
    }

    @DisplayName("매칭건수와 보너스매치여부에 따라 Rank 객체를 생성한다")
    @ParameterizedTest
    @CsvSource(value = {
            "6,false,FIRST",
            "6,true,FIRST",
            "5,true,SECOND",
            "5,false,THIRD",
            "4,false,FOURTH",
            "4,true,FOURTH",
            "3,false,FIFTH",
            "3,true,FIFTH",
            "2,true,MISS",
            "2,false,MISS",
            "1,false,MISS",
            "0,false,MISS",
    })
    void of(Integer matchedCount, Boolean bonusMatched, Rank expected) {
        assertThat(Rank.of(matchedCount, bonusMatched)).isEqualTo(expected);
    }
}