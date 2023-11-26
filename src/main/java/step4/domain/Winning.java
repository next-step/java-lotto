package step4.domain;

import java.util.ArrayList;
import java.util.List;

import step4.constant.Prize;
import step4.model.Lotteries;
import step4.util.LotteryUtil;

public class Winning {

    public static final int COUNT_BONUS = 5;

    private final int bonusWinNumber;
    private final Lottery win;

    public Winning(int bonus, List<Integer> winNumber) {
        bonusWinNumber = bonus;
        win = Lottery.of(winNumber);
    }

    public static Winning from(String bonusNumber, String winNumber) {
        int bonus = Integer.parseInt(bonusNumber);
        List<Integer> numbers = LotteryUtil.getNumbers(winNumber);

        checkBonusNumber(bonus, numbers);

        return new Winning(bonus, numbers);
    }

    public List<Prize> getPrizes(Lotteries lotteries) {
        List<Prize> result = new ArrayList<>();
        for (Lottery lottery : lotteries.getLotteries()) {
            result.add(find(lottery));
        }

        return result;
    }

    private Prize find(Lottery lottery) {
        int winCount = lottery.getMatchCount(win);
        return Prize.getPrize(winCount, matchBonus(lottery));
    }

    private boolean matchBonus(Lottery lottery) {
        return lottery.getLotteryNumbers().contains(bonusWinNumber);
    }

    private static void checkBonusNumber(int bonus, List<Integer> numbers) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException("잘 못 입력된 보너스 번호 - " + bonus);
        }
    }
}
