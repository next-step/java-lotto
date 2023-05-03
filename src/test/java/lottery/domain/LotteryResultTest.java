package lottery.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LotteryResultTest {
    List<Integer> defaultWinNumbers;
    LotteryResult defaultLotteryResult;

    @BeforeEach
    void setUp() {
        defaultWinNumbers = Arrays.asList(6, 5, 4, 3, 2, 1);
        defaultLotteryResult = new LotteryResult(defaultWinNumbers);
    }

    @Test
    void testEquals() {
        assertEquals(defaultLotteryResult, new LotteryResult(defaultWinNumbers));
    }

    @Test
    void testToString() {
        assertEquals(defaultLotteryResult.toString(), defaultWinNumbers.toString());
    }
}
