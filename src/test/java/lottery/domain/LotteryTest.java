package lottery.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LotteryTest {
    List<LotteryNumber> defaultLotteryNumbers;
    List<LotteryNumber> lessNumberOfLotteryNumbers;
    List<LotteryNumber> moreNumberOfLotteryNumbers;
    Lottery defaultLottery;

    @BeforeEach
    void setUp() {
        defaultLotteryNumbers = Arrays.asList(new LotteryNumber(1), new LotteryNumber(2), new LotteryNumber(3), new LotteryNumber(4), new LotteryNumber(5), new LotteryNumber(6));
        lessNumberOfLotteryNumbers = Arrays.asList(new LotteryNumber(1), new LotteryNumber(2), new LotteryNumber(3), new LotteryNumber(4), new LotteryNumber(5));
        moreNumberOfLotteryNumbers = Arrays.asList(new LotteryNumber(1), new LotteryNumber(2), new LotteryNumber(3), new LotteryNumber(4), new LotteryNumber(5), new LotteryNumber(6), new LotteryNumber(7));
        defaultLottery = Lottery.createLottery(defaultLotteryNumbers);
    }

    @Test
    void testCreateWinLottery() {
        assertDoesNotThrow(() -> Lottery.createLottery(defaultLotteryNumbers));
    }

    @Test
    void testEquals() {
        assertEquals(defaultLottery, Lottery.createLottery(defaultLotteryNumbers));
    }

    @Test
    void testToString() {
        assertEquals(defaultLottery.toString(), defaultLotteryNumbers.toString());
    }

    @Test
    @DisplayName("입력받은 숫자 개수가 로또 숫자 개수와 일치하지 않을 때 IllegalArgumentException을 발생시킨다")
    void wrongNumberofLotteryNumbers() {
        assertThrows(IllegalArgumentException.class, () -> Lottery.createLottery(lessNumberOfLotteryNumbers));
        assertThrows(IllegalArgumentException.class, () -> Lottery.createLottery(moreNumberOfLotteryNumbers));
    }

    @Test
    @DisplayName("입력받은 숫자 값이 정렬되어 있지 않더라도 정렬해서 저장한다")
    void unorderedLotteryNumbers() {
        List<LotteryNumber> unorderedLotteryNumbers = Arrays.asList(new LotteryNumber(6), new LotteryNumber(5), new LotteryNumber(4), new LotteryNumber(3), new LotteryNumber(2), new LotteryNumber(1));
        assertEquals(defaultLottery, Lottery.createLottery(unorderedLotteryNumbers));

    }
}
