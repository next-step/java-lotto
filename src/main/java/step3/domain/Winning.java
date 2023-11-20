package step3.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import step3.constant.Prize;
import step3.model.Lotteries;

public class Winning {

    private int bonusWinNumber;
    private final List<Integer> win;

    public static final int COUNT_BONUS = 5;

    public Winning(List<Integer> win) {
        this.win = win;
    }

    public static Winning from(String numberStr) {
        String[] split = numberStr.replaceAll(" ", "").split(",");
        List<Integer> numbers = Arrays.stream(split)
                                      .map(Integer::parseInt)
                                      .collect(Collectors.toList());

        return new Winning(numbers);
    }

    public void setBonusWinNumber(String bonusWinNumber) {
        this.bonusWinNumber = Integer.parseInt(bonusWinNumber);
    }

    public List<Prize> getPrizes(Lotteries lotteries) {
        List<Prize> result = new ArrayList<>();
        for (Lottery lottery : lotteries.getLotteries()) {
            result.add(find(lottery));
        }

        return result;
    }

    private Prize find(Lottery lottery) {
        int winCount = 0;
        for (int number : lottery.getNumbers()) {
            winCount += getWinCount(number);
        }

        return Prize.getPrize(winCount, matchBonus(winCount, lottery));
    }

    private int getWinCount(int number) {
        if (win.contains(number)) {
            return 1;
        }

        return 0;
    }

    private boolean matchBonus(int winCount, Lottery lottery) {
        if (COUNT_BONUS == winCount) {
            return lottery.getNumbers().contains(bonusWinNumber);
        }

        return false;
    }
}
