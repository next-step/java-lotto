package lotto.domain.constant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRankTest {

    @ParameterizedTest
    @CsvSource({"0,false,MISS", "1,false,MISS", "2,false,MISS", "3,false,FIFTH", "4,false,FOURTH",
        "5,false,THIRD", "5,true,SECOND", "6,false,FIRST"})
    void toWinLottoTest(int hitNumber, boolean matchBonus, LottoRank winLotto) {
        assertThat(LottoRank.valueOf(hitNumber, matchBonus)).isEqualTo(winLotto);
    }

}
