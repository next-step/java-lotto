package lottery.domain;

import java.util.Arrays;
import java.util.List;

public class Fixture {

    public static List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
    public static LotteryNumber createDefaultLotteryNumber = new LotteryNumber(numbers);
    public static Lottery oneToSixLottery = new Lottery(createDefaultLotteryNumber);
    public static Lottery oneToSixBonusBallLottery = new Lottery(new LotteryNumber(numbers,7));
    public static List<List<Integer>> manualNumbers = Arrays.asList(numbers);

    public static LotteryNumber createLotteryNumber(List<Integer> inputNumbers) {
        return new LotteryNumber(inputNumbers);
    }

    public static LotteryNumber createLotteryNumberWithBonus(int bonusNumber, Integer... inputNumbers) {
        return new LotteryNumber(Arrays.asList(inputNumbers), bonusNumber);
    }

    public static Lottery createLottery(List<Integer> inputNumbers) {
        return new Lottery(createLotteryNumber(inputNumbers));
    }

    public static Lottery createLotteryWithBonus(int bonusNumber, Integer... inputNumbers) {
        return new Lottery(createLotteryNumberWithBonus(bonusNumber, inputNumbers));
    }

}
