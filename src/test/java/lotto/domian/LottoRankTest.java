package lotto.domian;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {
    @Test
    @DisplayName("매치카운트가 5이고, 보너스볼이 false 면 3등")
    void giveMatchCount5AndBonusIsFalse_thenThird(){
        LottoRank rank = LottoRank.valueOfMatchCount(5, false);
        assertThat(rank).isEqualTo(LottoRank.THIRD);
    }

    @Test
    @DisplayName("매치카운트가 0이면 꽝.")
    void giveMatchCount_thenReturnLottoRankNone(){
        LottoRank rank = LottoRank.valueOfMatchCount(0, false);
        assertThat(rank).isEqualTo(LottoRank.MISS);
    }

    @Test
    @DisplayName("매치카운트가 5이고, 보너스볼이 true  면 2등")
    void giveMatchCount5AndBonusIsTrue_thenSecond(){
        LottoRank rank = LottoRank.valueOfMatchCount(5, true);
        assertThat(rank).isEqualTo(LottoRank.SECOND);
    }
}
