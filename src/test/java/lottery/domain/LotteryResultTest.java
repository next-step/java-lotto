package lottery.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LotteryResultTest {
    Integer defaultNumberOfLottery = 1;
    List<Integer> defaultWinNumbers;
    LotteryResult defaultLotteryResult;
    boolean defaultHasBonusBall = false;

    @BeforeEach
    void setUp() {
        defaultWinNumbers = Arrays.asList(7, 6, 5, 4, 3, 2, 1);
        defaultLotteryResult = new LotteryResult(defaultWinNumbers, defaultNumberOfLottery);
    }

    @Test
    @DisplayName("등수정보, 확인한 로또수 결과가 같으면 논리적으로 같은 객체다")
    void testEquals() {
        assertEquals(defaultLotteryResult, new LotteryResult(defaultWinNumbers, defaultNumberOfLottery));
    }

    @Test
    @DisplayName("문자열로 변환할 때 등수정보를 보여준다")
    void testToString() {
        assertEquals(defaultLotteryResult.toString(), defaultWinNumbers.toString());
    }
}
