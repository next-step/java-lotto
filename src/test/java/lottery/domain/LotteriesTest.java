package lottery.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LotteriesTest {
    int defaultNumberOfLottery = 3;
    int defaultPrice = defaultNumberOfLottery * LotteryPrice.VALUE;
    LotteryStrategy defaultLotteryStrategy;
    List<LotteryNumber> defaultLotteryNumbers;
    Lottery defaultLottery;
    BonusBall defaultBonusBall;
    WinLottery defaultWinLottery;
    List<Lottery> defaultLotteries;

    @BeforeEach
    void setUp() {
        defaultLotteryStrategy = new TestLotteryStrategy();
        defaultLotteryNumbers = Arrays.asList(new LotteryNumber(1), new LotteryNumber(2), new LotteryNumber(3), new LotteryNumber(4), new LotteryNumber(5), new LotteryNumber(6));
        defaultLottery = Lottery.createLottery(defaultLotteryNumbers);
        defaultBonusBall = new BonusBall(new LotteryNumber(7));
        defaultWinLottery = new WinLottery(defaultLottery, defaultBonusBall);
        defaultLotteries = new ArrayList<>();
        for (int i = 0; i < defaultNumberOfLottery; i++) {
            defaultLotteries.add(defaultLottery);
        }
    }

    @Test
    @DisplayName("로또를 기본로또전략으로 샀을 때 기본로또들 값이랑 같아야한다")
    void buy() {
        assertEquals(defaultLotteries, Lotteries.buy(defaultPrice, defaultLotteryStrategy));
    }

    @Test
    @DisplayName("기본로또들, 기본승리로또를 바탕으로 계산된 결과는 1등개수가 기본개수와 같고 일치하는 보너스볼이 없어야 한다")
    void calculateResult() {
        LotteryResult lotteryResult = new LotteryResult(Arrays.asList(0, 0, 0, 0, 0, 0, 0, defaultNumberOfLottery), defaultNumberOfLottery);
        assertEquals(lotteryResult, Lotteries.calculateResult(defaultLotteries, defaultWinLottery));

    }

    @Test
    @DisplayName("보너스볼이 있을 때 2등의 결과는 보너스볼에 따라 달라진다")
    void calculateResultWithBonusBall() {
        defaultBonusBall = new BonusBall(new LotteryNumber(6));
        List<LotteryNumber> winLotteryNumbersWithBonusBall = Arrays.asList(new LotteryNumber(1), new LotteryNumber(2), new LotteryNumber(3), new LotteryNumber(4), new LotteryNumber(5), new LotteryNumber(7));
        WinLottery winLotteryWithBonusBall = new WinLottery(Lottery.createLottery(winLotteryNumbersWithBonusBall), defaultBonusBall);
        LotteryResult lotteryResult = new LotteryResult(Arrays.asList(0, 0, 0, 0, 0, 0, defaultNumberOfLottery, 0), defaultNumberOfLottery);
        assertEquals(lotteryResult, Lotteries.calculateResult(defaultLotteries, winLotteryWithBonusBall));
    }
}
