package step4.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import step4.constant.Prize;
import step4.model.Lotteries;

public class Winning {

    public static final int COUNT_BONUS = 5;

    private int bonusWinNumber;
    private final Lottery win;

    public Winning(Set<Integer> winNumber) {
        win = Lottery.of(winNumber);
    }

    public static Winning from(String winNumber) {
        return new Winning(setWin(winNumber));
    }

    public void setBonusWinNumber(String number) {
        bonusWinNumber = Integer.parseInt(number);
    }

    public List<Prize> getPrizes(Lotteries lotteries) {
        List<Prize> result = new ArrayList<>();
        for (Lottery lottery : lotteries.getLotteries()) {
            result.add(find(lottery));
        }

        return result;
    }

    private Prize find(Lottery lottery) {
        int winCount = getWinCount(lottery.getNumbers());
        return Prize.getPrize(winCount, matchBonus(winCount, lottery));
    }

    public int getWinCount(List<Integer> numbers) {
        int winCount = 0;
        for (int number : numbers) {
            if (win.getNumbers().contains(number)) {
                winCount++;
            }
        }

        return winCount;
    }

    private boolean matchBonus(int winCount, Lottery lottery) {
        if (COUNT_BONUS == winCount) {
            return lottery.getNumbers().contains(bonusWinNumber);
        }

        return false;
    }

    private static Set<Integer> setWin(String numberStr) {
        String[] split = numberStr.replaceAll(" ", "")
                                  .split(",");

       return  Arrays.stream(split)
                     .map(Integer::parseInt)
                     .collect(Collectors.toSet());

    }
}
