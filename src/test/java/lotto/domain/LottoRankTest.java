package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class LottoRankTest {
    
    @DisplayName("로또 당첨 못한 등급인지 확인한다")
    @Test
    void isNoneRank(){
        LottoRank none = LottoRank.NONE;

        assertTrue(none.isNoneRank());
    }

    @DisplayName("현재 등수가 상금이 있는 등수인지 확인한다")
    @Test
    void hasRankedPrize(){
        LottoRank none = LottoRank.NONE;
        LottoRank first = LottoRank.FIRST;

        assertFalse(none.hasRankedPrize());
        assertTrue(first.hasRankedPrize());
    }
    
    @DisplayName("보너스볼 체크하는 등수인지 확인 가능하다")
    @Test
    void isCheckBonusNumber(){
        LottoRank second = LottoRank.SECOND;

        assertTrue(second.isCheckBonusNumber());
    }
}