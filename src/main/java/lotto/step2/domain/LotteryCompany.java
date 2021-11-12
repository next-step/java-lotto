package lotto.step2.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LotteryCompany {

    private List<Integer> winningNumbers = new ArrayList<>();
    private List<Lotto> lotteries = new ArrayList<>();

    public LotteryCompany(String winningNumbers) {
        setWinningNumbers(winningNumbers);
    }

    public LotteryCompany(String winningNumbers, List<Lotto> lotteries) {
        this(winningNumbers);
        setWinningNumbers(winningNumbers);
        this.lotteries = lotteries;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    private void setWinningNumbers(String input) {
        Arrays.stream(input.split(","))
                .forEach(s -> winningNumbers.add(Integer.valueOf(s.trim())));
    }

    public int getActualCountOfMatch(int expected) {
        if (expected != addCountOfMatch()) {
            return 0;
        }
        return addCountOfMatch();
    }

    private int addCountOfMatch() {
        int count = 0;
        for (Lotto lotto : lotteries) {
            count += lotto.getMatch(winningNumbers);
        }
        return count;
    }

}
