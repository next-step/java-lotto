package model;

import model.lotto.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @Test
    @DisplayName("맞는 수가 6이면 1등이다.")
    void of() {
        assertEquals(Rank.of(6, 1), Rank.FIRST);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:0", "2:0"}, delimiter = ':')
    @DisplayName("맞는 수가 3개 미만인 경우 꼴등이다.")
    public void of2(int matchCounts, int bonusMatchCount){
        assertEquals(Rank.of(matchCounts, bonusMatchCount), Rank.ZERO);
    }

    @Test
    @DisplayName("숫자 5개, 보너스 점수가 일치하면 2등이다.")
    public void of3(){
        assertEquals(Rank.of(5, 1), Rank.SECOND);
    }

    @Test
    @DisplayName("숫자 5개, 보너스 점수가 일치하지 않으면 3등이다.")
    public void of4(){
        assertEquals(Rank.of(5, 0), Rank.THIRD);
    }
}