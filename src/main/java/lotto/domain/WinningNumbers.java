package lotto.domain;

import lotto.factory.LotteryFactory;

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

    public List<LotteryNumber> getWinningNumberList() {
        return winningNumberList;
    }

    public int getBonusNumber() {
        return bonusNumber.getNumber();
    }
}
