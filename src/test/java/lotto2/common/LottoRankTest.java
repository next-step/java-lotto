package lotto2.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {
    @DisplayName("matchCount에 맞는 RANK정보를 반환")
    @Test
    void getRank() {
        //given
        int matchCount = 3;

        //when
        LottoRank rank = LottoRank.getRank(matchCount);

        //then
        assertEquals(LottoRank.FOURTH, rank);
    }

    @DisplayName("일치하는 rank정보가 없을때 MISS rank정보 반환")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 7})
    void getRankWithWrongMatchCount(int matchCount) {
        //when
        LottoRank rank = LottoRank.getRank(matchCount);

        //then
        assertEquals(LottoRank.MISS, rank);
    }
}