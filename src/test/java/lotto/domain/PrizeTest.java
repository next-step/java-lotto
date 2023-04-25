package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrizeTest {
    @DisplayName("1등의 일치하는 번호의 갯수가 6개인지 검증한다")
    @Test
    public void matchFirst() {
        //given
        Prize first = Prize.FIRST;
        int matchCount = 6;
        //when
        boolean match = first.isMatch(matchCount);
        //then
        assertTrue(match);
    }

    @DisplayName("3등의 일치하는 번호의 갯수가 5개인지 검증한다")
    @Test
    public void matchSecond() {
        //given
        Prize first = Prize.THIRD;
        int matchCount = 5;
        //when
        boolean match = first.isMatch(matchCount);
        //then
        assertTrue(match);
    }

    @DisplayName("4등의 일치하는 번호의 갯수가 4개인지 검증한다")
    @Test
    public void matchFourth() {
        //given
        Prize first = Prize.FOURTH;
        int matchCount = 4;
        //when
        boolean match = first.isMatch(matchCount);
        //then
        assertTrue(match);
    }

    @DisplayName("5등의 일치하는 번호의 3갯수가 개인지 검증한다")
    @Test
    public void matchFifth() {
        //given
        Prize first = Prize.FIFTH;
        int matchCount = 3;
        //when
        boolean match = first.isMatch(matchCount);
        //then
        assertTrue(match);
    }
}