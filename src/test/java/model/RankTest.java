package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @Test
    @DisplayName("맞는 수가 6이면 1등이다.")
    void of() {
        assertEquals(Rank.of(6), Rank.FIRST);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2,})
    @DisplayName("맞는 수가 3개 미만인 경우 꼴등이다.")
    public void of2(int matchCounts){
        assertEquals(Rank.of(matchCounts), Rank.ZERO);
    }
}