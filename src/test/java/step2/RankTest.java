package step2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step2.domain.Rank;

public class RankTest {
    public void match(Rank request, Rank actual, Integer expectedPrice) {
        assertAll(
            () -> assertEquals(request, actual),
            () -> assertEquals(request.getPrize(), expectedPrice)
        );
    }

    @Test
    @DisplayName("로또 순위 테스트")
    public void testRank() {
        Rank zero = Rank.of(0);
        Rank one = Rank.of(1);
        Rank two = Rank.of(2);
        Rank three = Rank.of(3);
        Rank four = Rank.of(4);
        Rank five = Rank.of(5);
        Rank six = Rank.of(6);
        assertAll(
            () -> match(zero, Rank.NONE, 0),
            () -> match(one, Rank.NONE, 0),
            () -> match(two, Rank.NONE, 0),
            () -> match(three, Rank.FOURTH, 5000),
            () -> match(four, Rank.THIRD, 50000),
            () -> match(five, Rank.SECOND, 1500000),
            () -> match(six, Rank.FIRST, 2000000000)
        );
    }

}
