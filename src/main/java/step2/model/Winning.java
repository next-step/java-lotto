package step2.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import step2.constant.Prize;

public class Winning {

    private int winCount;
    private final List<Integer> win;

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

    public List<Integer> getWin() {
        return win;
    }

    public int getWinCount() {
        return winCount;
    }

    public void setWinCount(int number) {
        this.winCount = win.contains(number) ? winCount + 1 : winCount;
    }

    public Prize getPrizes() {
        return Prize.getPrize(winCount);
    }
}
