package step2.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class LottoWinningsTest {

    @Test
    void lottoWinnings() {
        Map<Integer, Integer> winners = new HashMap<>();
        winners.put(3, 1);
        winners.put(4, 0);
        winners.put(5, 0);
        winners.put(6, 0);
        int winnings = LottoWinnings.getYield(winners);
        assertEquals(5000, winnings);
    }

}
