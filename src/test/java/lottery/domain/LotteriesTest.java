package lottery.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LotteriesTest {
    int defaultNumberOfLottery = 3;
    int defaultPrice = defaultNumberOfLottery * Lotteries.LOTTERY_PRICE;
    LotteryStrategy defaultLotteryStrategy;
    List<LotteryNumber> defaultLotteryNumbers;
    Lottery defaultLottery;
    List<Lottery> defaultLotteries;

    @BeforeEach
    void setUp() {
        defaultLotteryStrategy = new TestLotteryStrategy();
        defaultLotteryNumbers = Arrays.asList(new LotteryNumber(1), new LotteryNumber(2), new LotteryNumber(3), new LotteryNumber(4), new LotteryNumber(5), new LotteryNumber(6));
        defaultLottery = Lottery.createLottery(defaultLotteryNumbers);
        defaultLotteries = new ArrayList<>();
        for (int i = 0; i < defaultNumberOfLottery; i++) {
            defaultLotteries.add(defaultLottery);
        }
    }

    @Test
    void buy() {
        assertEquals(defaultLotteries, Lotteries.buy(defaultPrice, defaultLotteryStrategy));
    }

    @Test
    void calculateResult() {
        LotteryResult lotteryResult = new LotteryResult(Arrays.asList(0, 0, 0, 0, 0, 0, defaultNumberOfLottery), defaultNumberOfLottery);
        assertEquals(lotteryResult, Lotteries.calculateResult(defaultLotteries, defaultLottery));
    }
}
