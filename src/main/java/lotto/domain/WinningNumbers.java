package lotto.domain;

import lotto.factory.LotteryFactory;
import lotto.interfaces.LotteryGame;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    private List<LotteryNumber> winningNumberList;
    private final LotteryNumber bonusNumber;

    public WinningNumbers(String numbers, String bonusNumber) {
        this(new ArrayList<>(), LotteryNumber.of(bonusNumber));
        winningNumberList = LotteryFactory.create(numbers);
    }

    public WinningNumbers(List<LotteryNumber> winningNumberList, LotteryNumber bonusNumber) {
        this.winningNumberList = winningNumberList;
        this.bonusNumber = bonusNumber;
    }

    public Rank match(LotteryGame lotteryGame) {
        int countOfMatchedNumbers = 0;
        for (LotteryNumber number : lotteryGame.getLotteries()) {
            if (winningNumberList.contains(number)) {
                countOfMatchedNumbers++;
            }
        }
        return Rank.valueOf(countOfMatchedNumbers, lotteryGame.getLotteries().contains(LotteryNumber.of(bonusNumber.getNumber())));
    }

    public List<LotteryNumber> getWinningNumberList() {
        return winningNumberList;
    }

    public int getBonusNumber() {
        return bonusNumber.getNumber();
    }
}
