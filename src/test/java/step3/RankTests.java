package step3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Price;
import step3.domain.Rank;

public class RankTests {

    @Test
    @DisplayName("우승자 구하기")
    void firstWinnerTest() {
        Assertions.assertEquals(Rank.rank(6,true), Rank.FIRST);
        Assertions.assertEquals(Rank.rank(6,false), Rank.FIRST);
    }

    @Test
    @DisplayName("2등 구하기")
    void secondWinnerTest() {
        Assertions.assertEquals(Rank.rank(5,true), Rank.SECOND);
    }

    @Test
    @DisplayName("3등 구하기")
    void thirdWinnerTest() {
        Assertions.assertEquals(Rank.rank(5,false), Rank.THIRD);
    }

    @Test
    @DisplayName("4등 구하기")
    void FourthrTest() {
        Assertions.assertEquals(Rank.rank(4,true), Rank.FOURTH);
    }

}
