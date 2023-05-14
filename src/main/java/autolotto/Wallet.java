package autolotto;

import autolotto.lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private final List<Lotto> lottoList;

    public Wallet() {
        this.lottoList = new ArrayList<>();
    }

    public Wallet(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public void addLotto(Lotto lotto) {
        this.lottoList.add(lotto);
    }

    public int lottoSize() {
        return this.lottoList.size();
    }

    public int totalWinningMoneyOf(WinningNumbers winningNumbers) {
        return this.lottoList.stream()
                .map(lotto -> lotto.matchCount(winningNumbers))
                .mapToInt(matchCount -> Winning.winningOf(matchCount).winningMoney())
                .sum();
    }

    public int countOfLottoMatchingWith(WinningNumbers winningNumber, int matchCount) {
        return (int) this.lottoList.stream()
                .filter(lotto -> lotto.matchCount(winningNumber) == matchCount)
                .count();
    }

    public List<Lotto> allLotteries() {
        return new ArrayList<>(this.lottoList);
    }
}
