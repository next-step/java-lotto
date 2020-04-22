package Lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class RankTest {

    int countOfMatch;
    boolean matchBonus;

    @BeforeEach
    void setUp() {

    }

    @Test
    void valueOfFirst() {
        countOfMatch = 6;
        matchBonus = true;
        assertThat(Rank.valueOf(countOfMatch, matchBonus)).isEqualTo(Rank.FIRST);
    }

    @Test
    void valueOfSecond() {
        countOfMatch = 5;
        matchBonus = true;
        assertThat(Rank.valueOf(countOfMatch, matchBonus)).isEqualTo(Rank.SECOND);
    }

    @Test
    void valueOfThird() {
        countOfMatch = 5;
        matchBonus = false;
        assertThat(Rank.valueOf(countOfMatch, matchBonus)).isEqualTo(Rank.THIRD);
    }

    @Test
    void valueOfFifth() {
        countOfMatch = 3;
        matchBonus = true;
        assertThat(Rank.valueOf(countOfMatch, matchBonus)).isEqualTo(Rank.FIFTH);
    }

    @Test
    void valueOfMiss() {
        countOfMatch = 2;
        matchBonus = true;
        assertThat(Rank.valueOf(countOfMatch, matchBonus)).isEqualTo(Rank.MISS);
    }

}
