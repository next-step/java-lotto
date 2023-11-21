package step3.domain;

import java.util.ArrayList;
import java.util.List;

import step3.constant.Prize;
import step3.model.Lotteries;

public class Winning {

    public static final int COUNT_BONUS = 5;

    private final int bonusWinNumber;

    public Winning(int bonusWinNumber) {
        this.bonusWinNumber = bonusWinNumber;
    }

    public static Winning from(String bonusWinNumber) {
        return new Winning(Integer.parseInt(bonusWinNumber));
    }

    public List<Prize> getPrizes(Lotteries lotteries) {
        List<Prize> result = new ArrayList<>();
        for (Lottery lottery : lotteries.getLotteries()) {
            result.add(find(lottery));
        }

        return result;
    }

    private Prize find(Lottery lottery) {
        int winCount = lottery.getWinCount();
        return Prize.getPrize(winCount, matchBonus(winCount, lottery));
    }

    private boolean matchBonus(int winCount, Lottery lottery) {
        if (COUNT_BONUS == winCount) {
            return lottery.getBalls().contains(bonusWinNumber);
        }

        return false;
    }
}
