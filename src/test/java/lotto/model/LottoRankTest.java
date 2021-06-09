package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {

    @DisplayName("5개일치_보너스넘버")
    @Test
    void matchCount5AndBonusTest(){
        LottoRank actual = LottoRank.of(5, true);
        assertThat(actual).isEqualTo(LottoRank.MATCH_COUNT_FIVE_AND_BONUS);
    }

    @DisplayName("5개일치_not보너스넘버")
    @Test
    void matchCount5AndNotBonusTest(){
        LottoRank actual = LottoRank.of(5, false);
        assertThat(actual).isEqualTo(LottoRank.MATCH_COUNT_FIVE);
    }

    @DisplayName("보너스넘버만_가진경우")
    @Test
    void matchCountNot5AndBonusTest(){
        LottoRank actual = LottoRank.of(3, true);
        assertThat(actual).isEqualTo(LottoRank.MATCH_COUNT_THREE);
    }

    @DisplayName("매치갯수_벗어나는경우")
    @Test
    void matchCountOutOfRangeTest(){
        assertThatThrownBy(() -> {
            LottoRank actual = LottoRank.of(8, true);
        }).isInstanceOf(RuntimeException.class);
    }
}