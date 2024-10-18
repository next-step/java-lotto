package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoCashPrizeTest {
    @ParameterizedTest
    @CsvSource({"6,FIRST,false", "5,SECOND,true", "5,THIRD,false", "4,FOURTH,false", "3,FIFTH,false"})
    void from_일치하는_로또등수를_반환한다(int matchedCount, String prize, boolean hasBonus) {
        assertThat(LottoCashPrize.from(matchedCount, hasBonus)).isEqualTo(LottoCashPrize.valueOf(prize));
    }
}
