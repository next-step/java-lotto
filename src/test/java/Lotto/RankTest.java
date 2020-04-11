package Lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class RankTest {

    int countOfMatch;
    int winningMoney;
    boolean matchBonus;

    @BeforeEach
    void setUp() {
        countOfMatch = 5;
        winningMoney = 30_000_000;
        matchBonus = true;
    }

    @Test
    void valueOf() {
        assertThat(Rank.valueOf(countOfMatch, matchBonus)).isEqualTo(Rank.SECOND);
    }

}
