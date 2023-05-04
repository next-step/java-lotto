package lottery.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LotteryTest {
    List<Integer> defaultLotteryNumbers;
    List<Integer> lessNumberOfLotteryNumbers;
    List<Integer> moreNumberOfLotteryNumbers;
    List<Integer> lessValueOfLotteryNumbers;
    List<Integer> moreValueOfLotteryNumbers;
    Lottery defaultLottery;

    @BeforeEach
    void setUp() {
        defaultLotteryNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        lessNumberOfLotteryNumbers = Arrays.asList(1, 2, 3, 4, 5);
        moreNumberOfLotteryNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        lessValueOfLotteryNumbers = Arrays.asList(Lotteries.MIN_LOTTERY_NUMBER - 1, Lotteries.MIN_LOTTERY_NUMBER - 2, Lotteries.MIN_LOTTERY_NUMBER - 3, Lotteries.MIN_LOTTERY_NUMBER - 4, Lotteries.MIN_LOTTERY_NUMBER - 5, Lotteries.MIN_LOTTERY_NUMBER - 6);
        moreValueOfLotteryNumbers = Arrays.asList(Lotteries.MAX_LOTTERY_NUMBER + 1, Lotteries.MAX_LOTTERY_NUMBER + 2, Lotteries.MAX_LOTTERY_NUMBER + 3, Lotteries.MAX_LOTTERY_NUMBER + 4, Lotteries.MAX_LOTTERY_NUMBER + 5, Lotteries.MAX_LOTTERY_NUMBER + 6);
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
    @DisplayName("입력받은 숫자 값이 로또 숫자 최댓값을 넘어갈 때 IllegalArgumentException을 발생시킨다")
    void wrongValueOfLotteryNumbers() {
        assertThrows(IllegalArgumentException.class, () -> Lottery.createLottery(lessValueOfLotteryNumbers));
        assertThrows(IllegalArgumentException.class, () -> Lottery.createLottery(moreValueOfLotteryNumbers));
    }

    @Test
    @DisplayName("입력받은 숫자 값이 정렬되어 있지 않더라도 정렬해서 저장한다")
    void unorderedLotteryNumbers() {
        List<Integer> unorderedLotteryNumbers = Arrays.asList(6, 5, 4, 3, 2, 1);
        assertEquals(defaultLottery, Lottery.createLottery(unorderedLotteryNumbers));

    }
}
