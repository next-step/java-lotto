package lotto.domian;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {
    @Test
    @DisplayName("매치카운트에 맞는 결과를 반환한다.")
    void giveMatchCount_thenReturnLottoRank(){
        LottoRank rank = LottoRank.valueOfMatchCount(5);
        assertThat(rank).isEqualTo(LottoRank.SECOND);
    }

    @Test
    @DisplayName("매치카운트가 0이면 꽝.")
    void giveMaCountZero_thenReturnLottoRankNone(){
        LottoRank rank = LottoRank.valueOfMatchCount(0);
        assertThat(rank).isEqualTo(LottoRank.NONE);
    }
}
